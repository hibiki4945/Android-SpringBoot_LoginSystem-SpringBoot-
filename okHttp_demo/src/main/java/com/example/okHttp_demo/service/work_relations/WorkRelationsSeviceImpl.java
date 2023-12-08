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
    
    @Override
    public List<WorkSpotInfo> SearchBelongWorkSpot(String personalNo) {
        
        List<WorkRelationsInfo> res0 = wDao.findByWorkSpotDepart(personalNo);
        
        List<WorkSpotInfo> res = new ArrayList<>();
        
        for (WorkRelationsInfo item : res0) {
            res.add(wsDao.findByWorkSpotNo(item.getWorkSpotNo()));
        }
        
        return res;
    }
    
}
