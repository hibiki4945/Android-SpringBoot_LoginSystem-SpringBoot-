package com.example.okHttp_demo.service.work_relations;

import com.example.okHttp_demo.entity.WorkRelationsInfo;

import java.util.List;

public interface WorkRelationsSevice {
    
    public List<WorkRelationsInfo> SearchBelongWorkSpot(String personalNo);
    
}
