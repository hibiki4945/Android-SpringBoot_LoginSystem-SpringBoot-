package com.example.okHttp_demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "work_relations_info")
public class WorkRelationsInfo {
    
    @Id
    @Column(name = "WORK_RELATIONS_NO") 
    private int workRelationsNo;
    
    @Column(name = "WORK_SPOT_NO") 
    private String workSpotNo;
    
    @Column(name = "WORK_SPOT_COM_NM") 
    private String workSpotComNm;
    
    @Column(name = "WORK_SPOT_DEPART") 
    private String workSpotDepart;
    
    @Column(name = "WORK_SPOT") 
    private String workSpot;
    
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
