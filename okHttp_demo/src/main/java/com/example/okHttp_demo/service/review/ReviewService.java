package com.example.okHttp_demo.service.review;

import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.vo.BaseResponse;

import java.util.List;

public interface ReviewService {
    
    public BaseResponse<List<HolidayAcquire>> HolidayReview(String personalNo);
    
}
