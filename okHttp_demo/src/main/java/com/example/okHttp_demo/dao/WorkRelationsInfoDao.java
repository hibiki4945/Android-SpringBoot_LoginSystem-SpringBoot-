package com.example.okHttp_demo.dao;

import com.example.okHttp_demo.entity.WorkRelationsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkRelationsInfoDao extends JpaRepository<WorkRelationsInfo, Integer>{
    
    public List<WorkRelationsInfo> findByWorkSpotDepart(String personalNo);
    
}
