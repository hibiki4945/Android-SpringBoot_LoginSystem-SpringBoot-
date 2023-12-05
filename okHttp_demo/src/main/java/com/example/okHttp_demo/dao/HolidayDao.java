package com.example.okHttp_demo.dao;

import com.example.okHttp_demo.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayDao extends  JpaRepository<Holiday, String>{
    
}
