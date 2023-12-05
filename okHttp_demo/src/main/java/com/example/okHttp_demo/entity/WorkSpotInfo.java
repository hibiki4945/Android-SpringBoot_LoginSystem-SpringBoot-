package com.example.okHttp_demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "work_spot_info")
public class WorkSpotInfo {
    
    @Id
    @Column(name = "WORK_SPOT_NO") 
    private String workSpotNo;

    @Column(name = "WORK_SPOT_COM_NM") 
    private String workSpotComNm;

    @Column(name = "WORK_SPOT_DEPART") 
    private String workSpotDepart;
    
    @Column(name = "WORK_SPOT") 
    private String workSpot;
    
    @Column(name = "WORK_BEGIN_TIME") 
    private String workBeginTime;
    
    @Column(name = "WORK_END_TIME") 
    private String workEndTime;
    
    @Column(name = "LUNCH_BREAK") 
    private int lunchBreak;
    
    @Column(name = "WORK_HOURS") 
    private int workHours;
    
    @Column(name = "REG_YEAR") 
    private String regYear;
    
    @Column(name = "REG_MONTH") 
    private String regMonth;
    
    @Column(name = "REG_DAY") 
    private String regDay;
    
    @Column(name = "REG_AUTHOR") 
    private String regAuthor;
    
    @Column(name = "UPT_YEAR") 
    private String uptYear;
    
    @Column(name = "UPT_MONTH") 
    private String uptMonth;
    
    @Column(name = "UPT_DAY") 
    private String uptDay;
    
    @Column(name = "UPT_AUTHOR") 
    private String uptAuthor;
    
    @Column(name = "DEL_FLG") 
    private String delFlg;

    public String getWorkSpotNo() {
        return workSpotNo;
    }

    public void setWorkSpotNo(String workSpotNo) {
        this.workSpotNo = workSpotNo;
    }

    public String getWorkSpotComNm() {
        return workSpotComNm;
    }

    public void setWorkSpotComNm(String workSpotComNm) {
        this.workSpotComNm = workSpotComNm;
    }

    public String getWorkSpotDepart() {
        return workSpotDepart;
    }

    public void setWorkSpotDepart(String workSpotDepart) {
        this.workSpotDepart = workSpotDepart;
    }

    public String getWorkSpot() {
        return workSpot;
    }

    public void setWorkSpot(String workSpot) {
        this.workSpot = workSpot;
    }

    public String getWorkBeginTime() {
        return workBeginTime;
    }

    public void setWorkBeginTime(String workBeginTime) {
        this.workBeginTime = workBeginTime;
    }

    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    public int getLunchBreak() {
        return lunchBreak;
    }

    public void setLunchBreak(int lunchBreak) {
        this.lunchBreak = lunchBreak;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public String getRegYear() {
        return regYear;
    }

    public void setRegYear(String regYear) {
        this.regYear = regYear;
    }

    public String getRegMonth() {
        return regMonth;
    }

    public void setRegMonth(String regMonth) {
        this.regMonth = regMonth;
    }

    public String getRegDay() {
        return regDay;
    }

    public void setRegDay(String regDay) {
        this.regDay = regDay;
    }

    public String getRegAuthor() {
        return regAuthor;
    }

    public void setRegAuthor(String regAuthor) {
        this.regAuthor = regAuthor;
    }

    public String getUptYear() {
        return uptYear;
    }

    public void setUptYear(String uptYear) {
        this.uptYear = uptYear;
    }

    public String getUptMonth() {
        return uptMonth;
    }

    public void setUptMonth(String uptMonth) {
        this.uptMonth = uptMonth;
    }

    public String getUptDay() {
        return uptDay;
    }

    public void setUptDay(String uptDay) {
        this.uptDay = uptDay;
    }

    public String getUptAuthor() {
        return uptAuthor;
    }

    public void setUptAuthor(String uptAuthor) {
        this.uptAuthor = uptAuthor;
    }

    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public WorkSpotInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

    public WorkSpotInfo(String workSpotNo, String workSpotComNm, String workSpotDepart, String workSpot, String workBeginTime, String workEndTime, int lunchBreak, int workHours,
            String regYear, String regMonth, String regDay, String regAuthor, String uptYear, String uptMonth, String uptDay, String uptAuthor, String delFlg) {
        super();
        this.workSpotNo = workSpotNo;
        this.workSpotComNm = workSpotComNm;
        this.workSpotDepart = workSpotDepart;
        this.workSpot = workSpot;
        this.workBeginTime = workBeginTime;
        this.workEndTime = workEndTime;
        this.lunchBreak = lunchBreak;
        this.workHours = workHours;
        this.regYear = regYear;
        this.regMonth = regMonth;
        this.regDay = regDay;
        this.regAuthor = regAuthor;
        this.uptYear = uptYear;
        this.uptMonth = uptMonth;
        this.uptDay = uptDay;
        this.uptAuthor = uptAuthor;
        this.delFlg = delFlg;
    }
    
}
