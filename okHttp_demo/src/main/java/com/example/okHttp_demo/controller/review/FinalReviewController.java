package com.example.okHttp_demo.controller.review;

import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.service.review.FinalReviewService;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.HolidayReviewAcceptReq;
import com.example.okHttp_demo.vo.HolidayReviewDeniedReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 作成者:許智偉
 * 日付 2023/12/13
 */
@RestController
@RequestMapping("user")
public class FinalReviewController {

    @Autowired
    private FinalReviewService frService;

    /**
     * 現場審査完了の休暇申込を検索
     * 作成者:許智偉
     *
     * @param req 現場審査完了の休暇申込の検索に必要なデータ
     * @return 現場審査完了の休暇申込
     */
    @PostMapping("/holiday_final_review")
    public BaseResponse<List<HolidayAcquire>> HolidayFinalReview()
    {
//      現場審査完了の休暇申込を検索
        BaseResponse<List<HolidayAcquire>> res = frService.HolidayFinalReview();

//      現場審査完了の休暇申込を返す
        return new BaseResponse<List<HolidayAcquire>>(res.getStatus(), res.getMessage(), res.getData());
    }

    /**
     * 現場審査完了の休暇申込を承認
     * 作成者:許智偉
     *
     * @param req 現場審査完了の休暇申込の承認に必要なデータ
     * @return 本社審査完了の休暇申込の社員番号
     */
    @PostMapping("/holiday_final_review_accept")
    public BaseResponse<String> HolidayFinalReviewAccept(@RequestBody HolidayReviewAcceptReq req)
    {
//      現場審査完了の休暇申込を承認
        BaseResponse<String> res = frService.HolidayFinalReviewAccept(req.getPersonalNo(), req.getCalendarNo());

//      本社審査完了の休暇申込の社員番号を返す
        return new BaseResponse<String>(res.getStatus(), res.getMessage(), res.getData());
    }

    /**
     * 現場審査完了の休暇申込を却下
     * 作成者:許智偉
     *
     * @param req 現場審査完了の休暇申込の却下に必要なデータ
     * @return 本社審査完了の休暇申込の社員番号
     */
    @PostMapping("/holiday_final_review_denied")
    public BaseResponse<String> HolidayFinalReviewDenied(@RequestBody HolidayReviewDeniedReq req)
    {
//      現場審査完了の休暇申込を却下
        BaseResponse<String> res = frService.HolidayFinalReviewDenied(req.getPersonalNo(), req.getCalendarNo(), req.getRefusal());

//      本社審査完了の休暇申込の社員番号を返す
        return new BaseResponse<String>(res.getStatus(), res.getMessage(), res.getData());
    }
    
}
