package com.example.okHttp_demo.controller.record;

import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.service.record.RecordService;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.HolidayRecordReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class RecordController {

    @Autowired
    private RecordService rService;

    @PostMapping("/holiday_record")
    public BaseResponse<List<HolidayAcquire>> RecordShow(@RequestBody HolidayRecordReq req)
    {
        
        BaseResponse<List<HolidayAcquire>> res = rService.RecordShow(req);

        
        return new BaseResponse<List<HolidayAcquire>>(res.getStatus(), res.getMessage(), res.getData());
    }
    
}
