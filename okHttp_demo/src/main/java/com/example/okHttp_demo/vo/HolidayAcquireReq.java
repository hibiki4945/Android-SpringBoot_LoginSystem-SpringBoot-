package com.example.okHttp_demo.vo;

public class HolidayAcquireReq {

    private String personalNo;
    
    private String[] selectedWorkSpot;
    
    private String startDate;
    
    private String startTime;
    
    private String endDate;
    
    private String endTime;
    
    private String leaveType;
    
    private String reason;

    public String getPersonalNo() {
        return personalNo;
    }

    public void setPersonalNo(String personalNo) {
        this.personalNo = personalNo;
    }

    public String[] getSelectedWorkSpot() {
        return selectedWorkSpot;
    }

    public void setSelectedWorkSpot(String[] selectedWorkSpot) {
        this.selectedWorkSpot = selectedWorkSpot;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
