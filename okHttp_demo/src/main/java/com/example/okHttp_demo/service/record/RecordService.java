package com.example.okHttp_demo.service.record;

import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.HolidayRecordReq;

import java.util.List;

public interface RecordService {

    public BaseResponse<List<HolidayAcquire>> RecordShow(HolidayRecordReq req);
    
}
