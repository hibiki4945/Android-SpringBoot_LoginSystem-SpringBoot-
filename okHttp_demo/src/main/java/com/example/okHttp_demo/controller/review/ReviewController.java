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

@RestController
@RequestMapping("user")
public class ReviewController {

    @Autowired
    private ReviewService rService;
    
    @PostMapping("/holiday_review")
    public BaseResponse<List<HolidayAcquire>> HolidayReview(@RequestBody HolidayReviewReq req)
    {
        
        BaseResponse<List<HolidayAcquire>> res = rService.HolidayReview(req.getPersonalNo());


        return new BaseResponse<List<HolidayAcquire>>(res.getStatus(), res.getMessage(), res.getData());
    }
    

    @PostMapping("/holiday_review_accept")
    public BaseResponse<String> HolidayReviewAccept(@RequestBody HolidayReviewAcceptReq req)
    {

        BaseResponse<String> res = rService.HolidayReviewAccept(req.getCalendarNo());


        return new BaseResponse<String>(res.getStatus(), res.getMessage(), res.getData());
    }
    

    @PostMapping("/holiday_review_denied")
    public BaseResponse<String> HolidayReviewDenied(@RequestBody HolidayReviewDeniedReq req)
    {

        BaseResponse<String> res = rService.HolidayReviewDenied(req.getCalendarNo(), req.getRefusal());


        return new BaseResponse<String>(res.getStatus(), res.getMessage(), res.getData());
    }
    
}
