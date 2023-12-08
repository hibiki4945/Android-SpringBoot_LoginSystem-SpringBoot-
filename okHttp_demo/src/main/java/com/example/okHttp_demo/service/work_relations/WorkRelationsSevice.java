package com.example.okHttp_demo.service.work_relations;

import com.example.okHttp_demo.entity.WorkSpotInfo;

import java.util.List;

public interface WorkRelationsSevice {
    
    public List<WorkSpotInfo> SearchBelongWorkSpot(String personalNo);
    
}
