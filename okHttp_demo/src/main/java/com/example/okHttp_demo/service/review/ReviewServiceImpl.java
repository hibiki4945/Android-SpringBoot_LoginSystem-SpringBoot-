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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 作成者:許智偉 日付 2023/12/13
 */
@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private WorkRelationsInfoDao wDao;
    
    @Autowired
    private WorkSpotInfoDao wsDao;

    @Autowired
    private HolidayAcuireDao hDao;

    /**
     * 自分の部下の休暇申込を検索
     * 作成者:許智偉
     *
     * @param personalNo 自分の社員番号
     * @return 自分の部下の休暇申込
     */
    @Override
    public BaseResponse<List<HolidayAcquire>> HolidayReview(String personalNo) {
        
//        1. 找自己負責的所有現場
//        2. 找自己的所有部下
//        3. forEach各現場 用"建立者"+"現場"+"Ctg="1" 找請假單
        
        List<String[]> searchConditionList = new ArrayList<>();
        
//      自分の仕事関係表を検索
        List<WorkRelationsInfo> workRelationList = wDao.findByWorkSpotLeader(personalNo);
        
        List<WorkSpotInfo> workSpotList = new ArrayList<>();
        WorkSpotInfo workSpotTemp  = new WorkSpotInfo(); 
        
//      自分の仕事関係表で部下を検索
        for (WorkRelationsInfo item : workRelationList) {
            workSpotTemp = wsDao.findByWorkSpotNo(item.getWorkSpotNo());   
            
//          仕事関係表のリーダー番号と社員番号が一致しないを判断
            if(!item.getWorkSpotDepart().matches(personalNo)) {
//              部下と現場をまとめて保存
                String[] searchCondition = new String[2];
                searchCondition[0] = item.getWorkSpotDepart();
                searchCondition[1] = workSpotTemp.getWorkSpotComNm();
                searchConditionList.add(searchCondition);
            }    

        }
        
        List<HolidayAcquire> findAllHolidayAcquire = new ArrayList<>();
        List<HolidayAcquire> findHolidayAcquire = new ArrayList<>();
        
        for (String[] item : searchConditionList) {
//          当社員番号と当現場と現場審査中の休暇申込を検索
            findHolidayAcquire = hDao.findByWorkSpotDepartAndSelectedWorkSpotAndApprovalCtgAndDelFlg(item[0], item[1], "1", "0");

            findAllHolidayAcquire.addAll(findHolidayAcquire); 
        }
        
        return new BaseResponse<List<HolidayAcquire>>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), findAllHolidayAcquire);
        
    }

    /**
     * 自分の部下の休暇申込を承認
     * 作成者:許智偉
     *
     * @param personalNo 自分の社員番号
     * @param workSpotDepart 休暇申込の採番
     * @return 自分の部下の社員番号
     */
    @Override
    public BaseResponse<String> HolidayReviewAccept(String personalNo, String workSpotDepart) {
//      休暇申込の採番で休暇申込を検索
        HolidayAcquire res = hDao.findById(workSpotDepart).get();
//      承認区分を本社審査中と設定
        res.setApprovalCtg("2");
//      現在時刻を取得
        LocalDate localDate = LocalDate.now();
//      更新者を設定
        res.setUptAuthor(personalNo);
//      更新年を設定
        res.setUptYear(String.valueOf(localDate.getYear()));
//      更新月を設定
        res.setUptMonth(String.valueOf(localDate.getMonthValue()));
//      更新時を設定
        res.setUptDay(String.valueOf(localDate.getDayOfMonth()));

//      休暇申込を更新
        hDao.save(res);
        
        return new BaseResponse<String>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), workSpotDepart);
    }

    /**
     * 自分の部下の休暇申込を却下
     * 作成者:許智偉
     *
     * @param personalNo 自分の社員番号
     * @param workSpotDepart 休暇申込の採番
     * @param refusal 却下理由
     * @return 自分の部下の社員番号
     */
    @Override
    public BaseResponse<String> HolidayReviewDenied(String personalNo, String workSpotDepart, String refusal) {
//      休暇申込の採番で休暇申込を検索
        HolidayAcquire res = hDao.findById(workSpotDepart).get();
//      却下理由を設定
        res.setRefusal(refusal);
//      承認区分を本社審査中と設定
        res.setApprovalCtg("2");
//      現在時刻を取得
        LocalDate localDate = LocalDate.now();
//      更新者を設定
        res.setUptAuthor(personalNo);
//      更新年を設定
        res.setUptYear(String.valueOf(localDate.getYear()));
//      更新月を設定
        res.setUptMonth(String.valueOf(localDate.getMonthValue()));
//      更新時を設定
        res.setUptDay(String.valueOf(localDate.getDayOfMonth()));

//      休暇申込を更新
        hDao.save(res);
        
        return new BaseResponse<String>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), workSpotDepart);
    }
    
}
