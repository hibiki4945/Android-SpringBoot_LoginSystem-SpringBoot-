package com.example.okHttp_demo.service.holiday;

import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.HolidayAcquireRes;

public interface HolidayService {
    

    /**
     * カレンダーナンバーの採番を取得する。 作成者:
     *
     * @return カレンダーナンバー採番
     */
    String getCalendarNoSequence();

    /**
     * カレンダーナンバーの採番を更新する。 作成者:
     *
     * @return 更新されたカレンダーナンバーの採番
     */
    Integer updateCalendarNoSequence();
    
    public BaseResponse<HolidayAcquireRes> HolidayAcquire(String personalNo, 
                                                          String startDate,  
                                                          String startTime,  
                                                          String endDate,  
                                                          String endTime,  
                                                          String leaveType, 
                                                          String reason);
    
}
