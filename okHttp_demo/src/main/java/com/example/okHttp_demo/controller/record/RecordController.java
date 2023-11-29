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

/**
 * 作成者:許智偉
 * 日付 2023/11/24
 */
@RestController
@RequestMapping("user")
public class RecordController {

    @Autowired
    private RecordService rService;

    /**
     * 自分の休暇申込を検索
     * 作成者:許智偉
     *
     * @param req 休暇申込の検索に必要なデータ
     * @return 休暇申込の検索結果
     */
    @PostMapping("/holiday_record")
    public BaseResponse<List<HolidayAcquire>> RecordShow(@RequestBody HolidayRecordReq req)
    {

//      休暇申込を検索する
        BaseResponse<List<HolidayAcquire>> res = rService.RecordShow(req);

//      休暇申込の検索結果を返す
        return new BaseResponse<List<HolidayAcquire>>(res.getStatus(), res.getMessage(), res.getData());
    }
    
}
