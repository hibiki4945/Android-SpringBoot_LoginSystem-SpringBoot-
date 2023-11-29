package com.example.okHttp_demo.service.record;

import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.HolidayRecordReq;

import java.util.List;

/**
 * 作成者:許智偉 日付 2023/11/24
 */
public interface RecordService {
    
    /**
     * 自分の休暇申込を検索する。 作成者:許智偉
     *
     * @param req 休暇申込の検索に必要なデータ
     * @return 休暇申込の検索結果
     */
    public BaseResponse<List<HolidayAcquire>> RecordShow(HolidayRecordReq req);
    
}
