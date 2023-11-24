package com.example.okHttp_demo.dao;

import com.example.okHttp_demo.entity.HolidayAcquire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayAcuireDao extends JpaRepository<HolidayAcquire, String>{

//    // カレンダーナンバーの採番を取得する
//    Integer selectCalendarNoSequence();

//    // カレンダーナンバーの採番を更新する
//    Integer updateCalendarNoSequence();
    
//    // 休暇申込を追加する
//    Integer insertHolidayAcquire(HolidayAcquire holidayAcquire);
    
}
