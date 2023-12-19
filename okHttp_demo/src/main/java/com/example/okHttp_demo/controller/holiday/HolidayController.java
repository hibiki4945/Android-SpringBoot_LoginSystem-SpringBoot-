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
     * 休暇申込をデータベースに追加する。
     * 作成者:許智偉
     *
     * @param req  休暇申込に必要なデータ
     * @return 休暇申込の追加結果
     */
    @PostMapping("/holiday_acquire")
    public BaseResponse<HolidayAcquireRes> HolidayAcquire(@RequestBody HolidayAcquireReq req)
    {
        
//      休暇申込をデータベースに追加する
        BaseResponse<HolidayAcquireRes> res = hService.HolidayAcquire(req.getPersonalNo(),req.getSelectedWorkSpot(),req.getStartDate(),req.getStartTime(),req.getEndDate(),req.getEndTime(),req.getLeaveType(),req.getReason());
//      休暇申込の追加結果を確認
        if(!res.getStatus().matches("200")) { 
            return new BaseResponse<HolidayAcquireRes>(res.getStatus(),res.getMessage(),null);
        }
        
//      休暇申込の追加結果を返す
        return new BaseResponse<HolidayAcquireRes>(RtnCode.INSERT_SUCCESSFUL.getCode(),RtnCode.INSERT_SUCCESSFUL.getMessage(), res.getData());
    }
    
    @PostMapping("/get_all_vacationNo")
    public BaseResponse<String[]> GetAllVacationNo()
    {
        
        BaseResponse<String[]> res = hService.GetAllVacationNo();
        
        
        return new BaseResponse<String[]>(RtnCode.INSERT_SUCCESSFUL.getCode(),RtnCode.INSERT_SUCCESSFUL.getMessage(), res.getData());
    }
    
}
