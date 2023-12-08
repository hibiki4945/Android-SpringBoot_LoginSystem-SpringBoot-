package com.example.okHttp_demo.vo;

import com.example.okHttp_demo.entity.WorkSpotInfo;

import java.util.List;

public class SearchBelongWorkSpotRes {

    private List<WorkSpotInfo> workSpotInfo;

    public List<WorkSpotInfo> getWorkSpotInfo() {
        return workSpotInfo;
    }

    public void setWorkSpotInfo(List<WorkSpotInfo> workSpotInfo) {
        this.workSpotInfo = workSpotInfo;
    }

    public SearchBelongWorkSpotRes() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SearchBelongWorkSpotRes(List<WorkSpotInfo> workSpotInfo) {
        super();
        this.workSpotInfo = workSpotInfo;
    }
    
}
