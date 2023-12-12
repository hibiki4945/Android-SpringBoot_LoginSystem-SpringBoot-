package com.example.okHttp_demo.service.review;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.dao.HolidayAcuireDao;
import com.example.okHttp_demo.dao.WorkRelationsInfoDao;
import com.example.okHttp_demo.dao.WorkSpotInfoDao;
import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.entity.WorkRelationsInfo;
import com.example.okHttp_demo.entity.WorkSpotInfo;
import com.example.okHttp_demo.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private WorkRelationsInfoDao wDao;
    
    @Autowired
    private WorkSpotInfoDao wsDao;

    @Autowired
    private HolidayAcuireDao hDao;
    
    @Override
    public BaseResponse<List<HolidayAcquire>> HolidayReview(String personalNo) {
        
//        1. 找自己負責的所有現場
//        2. 找自己的所有部下
//        3. forEach各現場 用"建立者"+"現場"+"Ctg="1" 找請假單
        
        List<String[]> searchConditionList = new ArrayList<>();
        
//      找部下(記得將自己的資料(做去除))
        List<WorkRelationsInfo> workRelationList = wDao.findByWorkSpotLeader(personalNo);
        
        List<WorkSpotInfo> workSpotList = new ArrayList<>();
        WorkSpotInfo workSpotTemp  = new WorkSpotInfo(); 
        
//      workSpotList裡面是 該領導負責的現場
        for (WorkRelationsInfo item : workRelationList) {
            workSpotTemp = wsDao.findByWorkSpotNo(item.getWorkSpotNo());   
            
//              searchCondition是 搜尋請假單的條件(記得手動加上(Ctg="1"))
            if(!item.getWorkSpotDepart().matches(personalNo)) {
                String[] searchCondition = new String[2];
                searchCondition[0] = item.getWorkSpotDepart();
                searchCondition[1] = workSpotTemp.getWorkSpotComNm();
                searchConditionList.add(searchCondition);
            }    

        }
        
        List<HolidayAcquire> findAllHolidayAcquire = new ArrayList<>();
        List<HolidayAcquire> findHolidayAcquire = new ArrayList<>();
        
        for (String[] item : searchConditionList) {
            findHolidayAcquire = hDao.findByRegAuthorAndSelectedWorkSpotAndApprovalCtg(item[0], item[1], "1");
//            findHolidayAcquire = hDao.findByRegAuthorAndSelectedWorkSpot(item[0], item[1]);
            
            findAllHolidayAcquire.addAll(findHolidayAcquire); 
        }
        
//        System.out.println("findAllHolidayAcquire: "+findAllHolidayAcquire);
        
        return new BaseResponse<List<HolidayAcquire>>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), findAllHolidayAcquire);
        
    }

    @Override
    public BaseResponse<String> HolidayReviewAccept(String calendarNo) {
        
        HolidayAcquire res = hDao.findById(calendarNo).get();
        
        res.setApprovalCtg("2");
        
        hDao.save(res);
        
        return new BaseResponse<String>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), calendarNo);
    }

    @Override
    public BaseResponse<String> HolidayReviewDenied(String calendarNo, String refusal) {

        HolidayAcquire res = hDao.findById(calendarNo).get();
        
        res.setRefusal(refusal);
        
        res.setApprovalCtg("2");
        
        hDao.save(res);
        
        return new BaseResponse<String>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), calendarNo);
    }
    
}
