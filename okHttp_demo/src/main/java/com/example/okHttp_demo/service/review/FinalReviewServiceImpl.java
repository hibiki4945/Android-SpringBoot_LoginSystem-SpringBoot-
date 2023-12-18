package com.example.okHttp_demo.service.review;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.dao.HolidayAcuireDao;
import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作成者:許智偉 日付 2023/12/13
 */
@Service
public class FinalReviewServiceImpl implements FinalReviewService{

    @Autowired
    private HolidayAcuireDao hDao;

    /**
     * 現場審査完了の休暇申込を検索
     * 作成者:許智偉
     *
     * @return 現場審査完了の休暇申込
     */
    @Override
    public BaseResponse<List<HolidayAcquire>> HolidayFinalReview() {
//      現場審査完了の休暇申込を検索
        List<HolidayAcquire> res = hDao.findByApprovalCtgAndDelFlg("2", "0");

        return new BaseResponse<List<HolidayAcquire>>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), res);
    }

    /**
     * 現場審査完了の休暇申込を承認
     * 作成者:許智偉
     *
     * @param workSpotDepart 休暇申込の採番
     * @return 本社審査完了の休暇申込の社員番号
     */
    @Override
    public BaseResponse<String> HolidayFinalReviewAccept(String holidayAcquireNo) {
//      休暇申込の採番で休暇申込を検索
        HolidayAcquire res = hDao.findById(holidayAcquireNo).get();
//      承認区分を確認要と設定
        res.setApprovalCtg("4");
//      休暇申込を更新
        hDao.save(res);

        //      1. 找到該社員的同開始時間的請假單
        String workSpotDepart = res.getWorkSpotDepart();
        String startYear = res.getStartYear();
        String startMonth = res.getStartMonth();
        String startDay = res.getStartDay();
        String startTime = res.getStartTime();
        List<HolidayAcquire> other = hDao.findByWorkSpotDepartAndStartYearAndStartMonthAndStartDayAndStartTime(workSpotDepart, startYear, startMonth, startDay, startTime);

        //      2. 除此請假單(res) 都做(Del_Flag="1")
        for (HolidayAcquire item : other) {
            if(!item.getHolidayAcquireNo().matches(holidayAcquireNo)) {
                item.setDelFlg("1");
                hDao.save(item);
            }
        }
        
        return new BaseResponse<String>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), holidayAcquireNo);
    }

    /**
     * 現場審査完了の休暇申込を却下
     * 作成者:許智偉
     *
     * @param workSpotDepart 休暇申込の採番
     * @return 本社審査完了の休暇申込の社員番号
     */
    @Override
    public BaseResponse<String> HolidayFinalReviewDenied(String holidayAcquireNo) {
//      休暇申込の採番で休暇申込を検索
        HolidayAcquire res = hDao.findById(holidayAcquireNo).get();
//      承認区分を却下と設定
        res.setApprovalCtg("3");
//      休暇申込を更新
        hDao.save(res);
        
        return new BaseResponse<String>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), holidayAcquireNo);
    }
    
}
