package com.example.okHttp_demo.service.work_relations;

import com.example.okHttp_demo.dao.WorkRelationsInfoDao;
import com.example.okHttp_demo.dao.WorkSpotInfoDao;
import com.example.okHttp_demo.entity.WorkRelationsInfo;
import com.example.okHttp_demo.entity.WorkSpotInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkRelationsSeviceImpl implements WorkRelationsSevice{

    @Autowired
    private WorkRelationsInfoDao wDao;
    
    @Autowired
    private WorkSpotInfoDao wsDao;

    /**
     * 社員番号で担当現場を検索する。 作成者:許智偉
     *
     * @param personalNo 社員番号
     * @return 担当現場
     */
    @Override
    public List<WorkSpotInfo> SearchBelongWorkSpot(String personalNo) {
        
//      担当現場の勤務場所番号を検索
        List<WorkRelationsInfo> res0 = wDao.findByWorkSpotDepart(personalNo);
        
        List<WorkSpotInfo> res = new ArrayList<>();
//      勤務場所番号で勤務場所情報を検索
        for (WorkRelationsInfo item : res0) {
            res.add(wsDao.findByWorkSpotNo(item.getWorkSpotNo()));
        }
        
//      担当現場を返す
        return res;
    }
    
}
