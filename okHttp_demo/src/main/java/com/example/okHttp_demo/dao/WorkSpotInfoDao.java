package com.example.okHttp_demo.dao;

import com.example.okHttp_demo.entity.WorkSpotInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 作成者:許智偉 日付 2023/12/8
 */
public interface WorkSpotInfoDao extends JpaRepository<WorkSpotInfo, String>{

//  勤務場所番号で勤務場所情報を検索
    public WorkSpotInfo findByWorkSpotNo(String workSpotNo);
    
}
