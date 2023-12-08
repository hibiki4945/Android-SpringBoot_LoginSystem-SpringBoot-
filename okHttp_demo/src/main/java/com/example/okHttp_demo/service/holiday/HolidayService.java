package com.example.okHttp_demo.service.holiday;

import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.HolidayAcquireRes;

/**
 * 作成者:許智偉 日付 2023/11/24
 */
public interface HolidayService {
    

    /**
     * カレンダーナンバーの採番を取得する。 作成者:許智偉
     *
     * @return カレンダーナンバー採番
     */
    String getCalendarNoSequence();

    /**
     * カレンダーナンバーの採番を更新する。 作成者:許智偉
     *
     * @return 更新されたカレンダーナンバーの採番
     */
    Integer updateCalendarNoSequence();

    /**
     * 休暇申込を作成し、データベースに追加する。 作成者:許智偉
     *
     * @param personalNo 社員番号
     * @param startDate 開始日付
     * @param startTime 開始時間
     * @param endDate 終了日付
     * @param endTime 終了時間
     * @param leaveType 休暇番号
     * @param reason 休暇理由
     * @return 休暇申込の作成結果
     */
    public BaseResponse<HolidayAcquireRes> HolidayAcquire(String personalNo, 
                                                          String[] selectedWorkSpot, 
                                                          String startDate,  
                                                          String startTime,  
                                                          String endDate,  
                                                          String endTime,  
                                                          String leaveType, 
                                                          String reason);
    
}
