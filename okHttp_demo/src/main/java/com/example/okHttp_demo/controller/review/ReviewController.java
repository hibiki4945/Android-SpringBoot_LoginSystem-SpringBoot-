package com.example.okHttp_demo.controller.review;

import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.service.review.ReviewService;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.HolidayReviewAcceptReq;
import com.example.okHttp_demo.vo.HolidayReviewDeniedReq;
import com.example.okHttp_demo.vo.HolidayReviewReq;
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
public class ReviewController {

    @Autowired
    private ReviewService rService;

    /**
     * 自分の部下の休暇申込を検索
     * 作成者:許智偉
     *
     * @param req 自分の部下の休暇申込の検索に必要なデータ
     * @return 自分の部下の休暇申込
     */
    @PostMapping("/holiday_review")
    public BaseResponse<List<HolidayAcquire>> HolidayReview(@RequestBody HolidayReviewReq req)
    {
//      自分の部下の休暇申込を検索する
        BaseResponse<List<HolidayAcquire>> res = rService.HolidayReview(req.getPersonalNo());

//      自分の部下の休暇申込を返す
        return new BaseResponse<List<HolidayAcquire>>(res.getStatus(), res.getMessage(), res.getData());
    }
    
    /**
     * 自分の部下の休暇申込を承認
     * 作成者:許智偉
     *
     * @param req 自分の部下の休暇申込の承認に必要なデータ
     * @return 自分の部下の社員番号
     */
    @PostMapping("/holiday_review_accept")
    public BaseResponse<String> HolidayReviewAccept(@RequestBody HolidayReviewAcceptReq req)
    {
//      自分の部下の休暇申込を承認する
        BaseResponse<String> res = rService.HolidayReviewAccept(req.getPersonalNo(), req.getCalendarNo());

//      自分の部下の社員番号を返す
        return new BaseResponse<String>(res.getStatus(), res.getMessage(), res.getData());
    }
    
    /**
     * 自分の部下の休暇申込を却下
     * 作成者:許智偉
     *
     * @param req 自分の部下の休暇申込の却下に必要なデータ
     * @return 自分の部下の社員番号
     */
    @PostMapping("/holiday_review_denied")
    public BaseResponse<String> HolidayReviewDenied(@RequestBody HolidayReviewDeniedReq req)
    {
//      自分の部下の休暇申込を却下する
        BaseResponse<String> res = rService.HolidayReviewDenied(req.getPersonalNo(), req.getCalendarNo());

//      自分の部下の社員番号を返す
        return new BaseResponse<String>(res.getStatus(), res.getMessage(), res.getData());
    }
    
}
