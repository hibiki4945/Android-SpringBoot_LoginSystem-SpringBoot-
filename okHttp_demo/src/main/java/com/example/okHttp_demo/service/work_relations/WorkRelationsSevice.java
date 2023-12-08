package com.example.okHttp_demo.service.work_relations;

import com.example.okHttp_demo.entity.WorkSpotInfo;

import java.util.List;

/**
 * 作成者:許智偉 日付 2023/12/8
 */
public interface WorkRelationsSevice {

    /**
     * 社員番号で担当現場を検索する。 作成者:許智偉
     *
     * @param personalNo 社員番号
     * @return 担当現場
     */
    public List<WorkSpotInfo> SearchBelongWorkSpot(String personalNo);
    
}
