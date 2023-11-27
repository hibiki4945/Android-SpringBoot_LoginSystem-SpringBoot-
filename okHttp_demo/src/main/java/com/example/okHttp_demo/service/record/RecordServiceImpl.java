package com.example.okHttp_demo.service.record;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.dao.HolidayAcuireDao;
import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.HolidayRecordReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    private HolidayAcuireDao hDao;
    
    @Override
    public BaseResponse<List<HolidayAcquire>> RecordShow(HolidayRecordReq req) {
        
        List<HolidayAcquire> res = hDao.findByRegAuthor(req.getRegAuthor());
        
//        if(res == null) {
//            return new BaseResponse<List<HolidayAcquire>>(RtnCode.SEARCHING_EMPTY.getCode(), RtnCode.SEARCHING_EMPTY.getMessage(), null);
//        }
        
        return new BaseResponse<List<HolidayAcquire>>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), res);
        
    }

}
