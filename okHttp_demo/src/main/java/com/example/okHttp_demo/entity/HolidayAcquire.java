package com.example.okHttp_demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "holiday_acquire")
public class HolidayAcquire {
    
    @Id
    @Column(name = "CALENDAR_NO")
    private String calendarNo;
    
    @Column(name = "START_YEAR")
    private String startYear;

    @Column(name = "START_MONTH")
    private String startMonth;

    @Column(name = "START_DAY")
    private String startDay;

    @Column(name = "START_TIME")
    private String startTime;

    @Column(name = "END_YEAR")
    private String endYear;

    @Column(name = "END_MONTH")
    private String endMonth;

    @Column(name = "END_DAY")
    private String endDay;

    @Column(name = "END_TIME")
    private String endTime;

    @Column(name = "VACATION_DAYS")
    private int vacationDays;

    @Column(name = "VACATION_NO")
    private String vacationNo;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "APPROVAL_CTG")
    private String approvalCtg;

    @Column(name = "REFUSAL")
    private String refusal;

    @Column(name = "COMMENT")
    private String comment;

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

    public String getCalendarNo() {
        return calendarNo;
    }

    public void setCalendarNo(String calendarNo) {
        this.calendarNo = calendarNo;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public String getVacationNo() {
        return vacationNo;
    }

    public void setVacationNo(String vacationNo) {
        this.vacationNo = vacationNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApprovalCtg() {
        return approvalCtg;
    }

    public void setApprovalCtg(String approvalCtg) {
        this.approvalCtg = approvalCtg;
    }

    public String getRefusal() {
        return refusal;
    }

    public void setRefusal(String refusal) {
        this.refusal = refusal;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public HolidayAcquire() {
        super();
        // TODO Auto-generated constructor stub
    }

    public HolidayAcquire(String calendarNo, String startYear, String startMonth, String startDay, String startTime, String endYear, String endMonth, String endDay, String endTime,
            int vacationDays, String vacationNo, String reason, String approvalCtg, String refusal, String comment, String regYear, String regMonth, String regDay,
            String regAuthor, String uptYear, String uptMonth, String uptDay, String uptAuthor, String delFlg) {
        super();
        this.calendarNo = calendarNo;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.startTime = startTime;
        this.endYear = endYear;
        this.endMonth = endMonth;
        this.endDay = endDay;
        this.endTime = endTime;
        this.vacationDays = vacationDays;
        this.vacationNo = vacationNo;
        this.reason = reason;
        this.approvalCtg = approvalCtg;
        this.refusal = refusal;
        this.comment = comment;
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
