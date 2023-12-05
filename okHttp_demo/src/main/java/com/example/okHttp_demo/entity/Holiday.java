package com.example.okHttp_demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "holiday")
public class Holiday {
    
    @Id
    @Column(name = "HOLIDAY_NO") 
    private String holidayNo;
    
    @Column(name = "HOLIDAY_NM") 
    private String holidayNm;
    
    @Column(name = "YEAR") 
    private String year;
    
    @Column(name = "MONTH") 
    private String month;
    
    @Column(name = "DAY") 
    private String day;
    
    @Column(name = "CALENDAR_NO") 
    private String calendarNo;
    
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
    
}
