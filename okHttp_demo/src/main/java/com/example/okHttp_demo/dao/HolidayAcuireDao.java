package com.example.okHttp_demo.dao;

import com.example.okHttp_demo.entity.HolidayAcquire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HolidayAcuireDao extends JpaRepository<HolidayAcquire, String>{
    
    public List<HolidayAcquire> findByRegAuthor(String regAuthor);
    
}
