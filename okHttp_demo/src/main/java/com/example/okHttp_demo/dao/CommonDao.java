package com.example.okHttp_demo.dao;

import com.example.okHttp_demo.entity.Common;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommonDao extends JpaRepository<Common, Integer>{
    
    public List<Common> findByCateNo(String cateNo);
    
}
