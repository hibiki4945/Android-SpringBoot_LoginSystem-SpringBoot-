package com.example.okHttp_demo.service.review;

import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.vo.BaseResponse;

import java.util.List;

public interface FinalReviewService {

    public BaseResponse<List<HolidayAcquire>> HolidayFinalReview();

    public BaseResponse<String> HolidayFinalReviewAccept(String calendarNo);
    
    public BaseResponse<String> HolidayFinalReviewDenied(String calendarNo);
    
}
