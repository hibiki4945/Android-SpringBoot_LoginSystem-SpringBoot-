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
        List<HolidayAcquire> res = hDao.findByApprovalCtg("2");
        
        return new BaseResponse<List<HolidayAcquire>>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), res);
    }

    /**
     * 現場審査完了の休暇申込を承認
     * 作成者:許智偉
     *
     * @param calendarNo 休暇申込の採番
     * @return 本社審査完了の休暇申込の社員番号
     */
    @Override
    public BaseResponse<String> HolidayFinalReviewAccept(String calendarNo) {
//      休暇申込の採番で休暇申込を検索
        HolidayAcquire res = hDao.findById(calendarNo).get();
//      承認区分を確認要と設定
        res.setApprovalCtg("4");
//      休暇申込を更新
        hDao.save(res);
        
        return new BaseResponse<String>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), calendarNo);
    }

    /**
     * 現場審査完了の休暇申込を却下
     * 作成者:許智偉
     *
     * @param calendarNo 休暇申込の採番
     * @return 本社審査完了の休暇申込の社員番号
     */
    @Override
    public BaseResponse<String> HolidayFinalReviewDenied(String calendarNo) {
//      休暇申込の採番で休暇申込を検索
        HolidayAcquire res = hDao.findById(calendarNo).get();
//      承認区分を却下と設定
        res.setApprovalCtg("3");
//      休暇申込を更新
        hDao.save(res);
        
        return new BaseResponse<String>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), calendarNo);
    }
    
}
