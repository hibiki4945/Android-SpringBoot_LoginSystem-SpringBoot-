package com.example.okHttp_demo.service.work_relations;

import com.example.okHttp_demo.dao.WorkRelationsInfoDao;
import com.example.okHttp_demo.entity.WorkRelationsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkRelationsSeviceImpl implements WorkRelationsSevice{

    @Autowired
    private WorkRelationsInfoDao wDao;
    
    @Override
    public List<WorkRelationsInfo> SearchBelongWorkSpot(String personalNo) {
        
        return wDao.findByWorkSpotDepart(personalNo);
        
//        return null;
    }
    
}
