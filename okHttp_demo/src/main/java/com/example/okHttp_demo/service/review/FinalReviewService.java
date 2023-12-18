package com.example.okHttp_demo.service.review;

import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.vo.BaseResponse;

import java.util.List;

/**
 * 作成者:許智偉 日付 2023/12/13
 */
public interface FinalReviewService {

    /**
     * 現場審査完了の休暇申込を検索
     * 作成者:許智偉
     *
     * @return 現場審査完了の休暇申込
     */
    public BaseResponse<List<HolidayAcquire>> HolidayFinalReview();

    /**
     * 現場審査完了の休暇申込を承認
     * 作成者:許智偉
     *
     * @param personalNo 自分の社員番号
     * @param holidayAcquireNo 休暇申込の採番
     * @return 本社審査完了の休暇申込の社員番号
     */
    public BaseResponse<String> HolidayFinalReviewAccept(String personalNo, String holidayAcquireNo);

    /**
     * 現場審査完了の休暇申込を却下
     * 作成者:許智偉
     *
     * @param personalNo 自分の社員番号
     * @param holidayAcquireNo 休暇申込の採番
     * @param refusal 却下理由
     * @return 本社審査完了の休暇申込の社員番号
     */
    public BaseResponse<String> HolidayFinalReviewDenied(String personalNo, String holidayAcquireNo, String refusal);
    
}
