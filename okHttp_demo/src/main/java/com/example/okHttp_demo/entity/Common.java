package com.example.okHttp_demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "common")
public class Common {

    @Id
    @Column(name = "COMMON_NO") 
    private int holidayNo;
    
    @Column(name = "CATE_NO") 
    private String cateNo;
    
    @Column(name = "SUB_CATE_NO") 
    private String subCateNo;
    
    @Column(name = "NAME") 
    private String name;

    public int getHolidayNo() {
        return holidayNo;
    }

    public void setHolidayNo(int holidayNo) {
        this.holidayNo = holidayNo;
    }

    public String getCateNo() {
        return cateNo;
    }

    public void setCateNo(String cateNo) {
        this.cateNo = cateNo;
    }

    public String getSubCateNo() {
        return subCateNo;
    }

    public void setSubCateNo(String subCateNo) {
        this.subCateNo = subCateNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Common() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Common(int holidayNo, String cateNo, String subCateNo, String name) {
        super();
        this.holidayNo = holidayNo;
        this.cateNo = cateNo;
        this.subCateNo = subCateNo;
        this.name = name;
    }
    
}
