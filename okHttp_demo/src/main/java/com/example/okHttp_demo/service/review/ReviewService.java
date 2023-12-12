package com.example.okHttp_demo.service.review;

import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.vo.BaseResponse;

import java.util.List;

public interface ReviewService {
    
    public BaseResponse<List<HolidayAcquire>> HolidayReview(String personalNo);
    
    public BaseResponse<String> HolidayReviewAccept(String calendarNo);
    
    public BaseResponse<String> HolidayReviewDenied(String calendarNo, String refusal);
    
}
