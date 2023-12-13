package com.example.okHttp_demo.dao;

import com.example.okHttp_demo.entity.HolidayAcquire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 作成者:許智偉 日付 2023/12/8
 */
public interface HolidayAcuireDao extends JpaRepository<HolidayAcquire, String>{
    
//  作成者で休暇申込を検索
    public List<HolidayAcquire> findByWorkSpotDepart(String workSpotDepart);
    
    public List<HolidayAcquire> findByWorkSpotDepartAndSelectedWorkSpotAndApprovalCtg(String workSpotDepart, String SelectedWorkSpot, String approvalCtg);
    
    public List<HolidayAcquire> findByApprovalCtg(String approvalCtg);
    
}
