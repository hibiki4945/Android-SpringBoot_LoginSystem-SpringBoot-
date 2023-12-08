package com.example.okHttp_demo.dao;

import com.example.okHttp_demo.entity.WorkSpotInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkSpotInfoDao extends JpaRepository<WorkSpotInfo, String>{

    public WorkSpotInfo findByWorkSpotNo(String workSpotNo);
    
}
