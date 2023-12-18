package com.example.okHttp_demo.dao;

import com.example.okHttp_demo.entity.HolidayAcquire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 作成者:許智偉 日付 2023/12/8
 */
public interface HolidayAcuireDao extends JpaRepository<HolidayAcquire, String>{
    
//  社員番号で休暇申込を検索
    public List<HolidayAcquire> findByWorkSpotDepart(String workSpotDepart);
//  社員番号と現場と承認区分で休暇申込を検索    
    public List<HolidayAcquire> findByWorkSpotDepartAndSelectedWorkSpotAndApprovalCtgAndDelFlg(String workSpotDepart, String SelectedWorkSpot, String approvalCtg, String delFlg);
//  承認区分で休暇申込を検索    
    public List<HolidayAcquire> findByApprovalCtgAndDelFlg(String approvalCtg, String delFlg);
   
    public List<HolidayAcquire> findByWorkSpotDepartAndStartYearAndStartMonthAndStartDayAndStartTime(String workSpotDepart, String startYear, String startMonth, String startDay, String startTime);
    
}
