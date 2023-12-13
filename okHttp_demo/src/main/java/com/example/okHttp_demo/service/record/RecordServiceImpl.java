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

    /**
     * 自分の休暇申込を検索する。 作成者:許智偉
     *
     * @param req 休暇申込の検索に必要なデータ
     * @return 休暇申込の検索結果
     */
    @Override
    public BaseResponse<List<HolidayAcquire>> RecordShow(HolidayRecordReq req) {
        
//      自分の休暇申込を検索
        List<HolidayAcquire> res = hDao.findByWorkSpotDepart(req.getWorkSpotDepart());

//      休暇申込の検索結果を返す
        return new BaseResponse<List<HolidayAcquire>>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), res);
        
    }

}
