package com.example.okHttp_demo.dao;

import com.example.okHttp_demo.entity.HolidayAcquireSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface HolidayAcuireSequenceDao extends JpaRepository<HolidayAcquireSequence, Integer>{

//    // カレンダーナンバーの採番を更新する
//    Integer updateCalendarNoSequence();
    
    @Modifying
    @Transactional
    @Query(value = "update holiday_acquire_sequence h"
            + " set h.ID_NUMBER = :inputIdNew "
            + " where h.ID_NUMBER = :inputId ", nativeQuery = true)
    public int updateById(@Param("inputId") int id, 
                          @Param("inputIdNew") int idNew
                          );
    
}
