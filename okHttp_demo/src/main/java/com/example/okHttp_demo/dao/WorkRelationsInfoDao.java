package com.example.okHttp_demo.dao;

import com.example.okHttp_demo.entity.WorkRelationsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 作成者:許智偉 日付 2023/12/8
 */
public interface WorkRelationsInfoDao extends JpaRepository<WorkRelationsInfo, Integer>{

//  社員番号で勤務関係情報を検索
    public List<WorkRelationsInfo> findByWorkSpotDepart(String personalNo);
    
    public List<WorkRelationsInfo> findByWorkSpotLeader(String personalNo);
    
}
