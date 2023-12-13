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

@RestController
@RequestMapping("user")
public class FinalReviewController {

    @Autowired
    private FinalReviewService frService;

    @PostMapping("/holiday_final_review")
    public BaseResponse<List<HolidayAcquire>> HolidayFinalReview()
    {
        
        BaseResponse<List<HolidayAcquire>> res = frService.HolidayFinalReview();


        return new BaseResponse<List<HolidayAcquire>>(res.getStatus(), res.getMessage(), res.getData());
    }

    @PostMapping("/holiday_final_review_accept")
    public BaseResponse<String> HolidayFinalReviewAccept(@RequestBody HolidayReviewAcceptReq req)
    {

        BaseResponse<String> res = frService.HolidayFinalReviewAccept(req.getCalendarNo());


        return new BaseResponse<String>(res.getStatus(), res.getMessage(), res.getData());
    }
    

    @PostMapping("/holiday_final_review_denied")
    public BaseResponse<String> HolidayFinalReviewDenied(@RequestBody HolidayReviewDeniedReq req)
    {

        BaseResponse<String> res = frService.HolidayFinalReviewDenied(req.getCalendarNo());


        return new BaseResponse<String>(res.getStatus(), res.getMessage(), res.getData());
    }
    
}
