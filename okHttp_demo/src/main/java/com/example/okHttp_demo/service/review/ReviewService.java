package com.example.okHttp_demo.service.review;

import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.vo.BaseResponse;

import java.util.List;

/**
 * 作成者:許智偉 日付 2023/12/13
 */
public interface ReviewService {

    /**
     * 自分の部下の休暇申込を検索
     * 作成者:許智偉
     *
     * @param personalNo 自分の社員番号
     * @return 自分の部下の休暇申込
     */
    public BaseResponse<List<HolidayAcquire>> HolidayReview(String personalNo);

    /**
     * 自分の部下の休暇申込を承認
     * 作成者:許智偉
     *
     * @param workSpotDepart 休暇申込の採番
     * @return 自分の部下の社員番号
     */
    public BaseResponse<String> HolidayReviewAccept(String workSpotDepart);

    /**
     * 自分の部下の休暇申込を却下
     * 作成者:許智偉
     *
     * @param workSpotDepart 休暇申込の採番
     * @param refusal 却下理由
     * @return 自分の部下の社員番号
     */
    public BaseResponse<String> HolidayReviewDenied(String workSpotDepart, String refusal);
    
}
