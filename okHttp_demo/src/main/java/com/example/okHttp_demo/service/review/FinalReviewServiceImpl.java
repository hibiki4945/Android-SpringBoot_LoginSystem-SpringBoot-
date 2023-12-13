package com.example.okHttp_demo.service.review;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.dao.HolidayAcuireDao;
import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalReviewServiceImpl implements FinalReviewService{

    @Autowired
    private HolidayAcuireDao hDao;
    
    @Override
    public BaseResponse<List<HolidayAcquire>> HolidayFinalReview() {
        
        List<HolidayAcquire> res = hDao.findByApprovalCtg("2");
        
        return new BaseResponse<List<HolidayAcquire>>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), res);
    }

    @Override
    public BaseResponse<String> HolidayFinalReviewAccept(String calendarNo) {

        HolidayAcquire res = hDao.findById(calendarNo).get();
        
        res.setApprovalCtg("4");
        
        hDao.save(res);
        
        return new BaseResponse<String>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), calendarNo);
    }

    @Override
    public BaseResponse<String> HolidayFinalReviewDenied(String calendarNo) {

        HolidayAcquire res = hDao.findById(calendarNo).get();
        
        res.setApprovalCtg("3");
        
        hDao.save(res);
        
        return new BaseResponse<String>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), calendarNo);
    }
    
}
