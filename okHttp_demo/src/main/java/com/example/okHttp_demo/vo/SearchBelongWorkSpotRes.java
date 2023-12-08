package com.example.okHttp_demo.vo;

import com.example.okHttp_demo.entity.WorkRelationsInfo;

import java.util.List;

public class SearchBelongWorkSpotRes {

    private List<WorkRelationsInfo> workRelationsInfo;

    public List<WorkRelationsInfo> getWorkRelationsInfo() {
        return workRelationsInfo;
    }

    public void setWorkRelationsInfo(List<WorkRelationsInfo> workRelationsInfo) {
        this.workRelationsInfo = workRelationsInfo;
    }

    public SearchBelongWorkSpotRes(List<WorkRelationsInfo> workRelationsInfo) {
        super();
        this.workRelationsInfo = workRelationsInfo;
    }

    public SearchBelongWorkSpotRes() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
}
