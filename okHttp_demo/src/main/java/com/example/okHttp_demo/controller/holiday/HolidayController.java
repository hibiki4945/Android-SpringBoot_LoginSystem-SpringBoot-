package com.example.okHttp_demo.controller.holiday;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.service.holiday.HolidayService;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.HolidayAcquireReq;
import com.example.okHttp_demo.vo.HolidayAcquireRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作成者:許智偉
 * 日付 2023/11/23
 */
@RestController
@RequestMapping("user")
public class HolidayController {

    @Autowired
    private HolidayService hService;

    /**
     * ログインする。
     * 作成者:許智偉
     *
     * @param req  ログインに必要なデータ
     * @return ログインの結果
     */
    @PostMapping("/holiday_acquire")
    public BaseResponse<HolidayAcquireRes> HolidayAcquire(@RequestBody HolidayAcquireReq req)
    {
        
//      ログインする
        BaseResponse<HolidayAcquireRes> res = hService.HolidayAcquire(req.getPersonalNo(),
                                                                      req.getStartDate(),
                                                                      req.getStartTime(),
                                                                      req.getEndDate(),
                                                                      req.getEndTime(),
                                                                      req.getLeaveType(),
                                                                      req.getReason());
        if(!res.getStatus().matches("200")) {
            return new BaseResponse<HolidayAcquireRes>(res.getStatus(),res.getMessage(),null);
        }
        
//      ログインの結果を返す
        return new BaseResponse<HolidayAcquireRes>(RtnCode.INSERT_SUCCESSFUL.getCode(),RtnCode.INSERT_SUCCESSFUL.getMessage(), res.getData());
    }
    
}
