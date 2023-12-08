package com.example.okHttp_demo.controller.work_relations;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.entity.WorkRelationsInfo;
import com.example.okHttp_demo.service.work_relations.WorkRelationsSevice;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.SearchBelongWorkSpotReq;
import com.example.okHttp_demo.vo.SearchBelongWorkSpotRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class WorkRelationsController {

    @Autowired
    private WorkRelationsSevice wService;

    @PostMapping("/search_belong_work_spot")
    public BaseResponse<SearchBelongWorkSpotRes> SearchBelongWorkSpot(@RequestBody SearchBelongWorkSpotReq req)
    {
        
        List<WorkRelationsInfo> res0 = wService.SearchBelongWorkSpot(req.getPersonalNo());
        
        SearchBelongWorkSpotRes res = new SearchBelongWorkSpotRes(res0);
//        for (WorkRelationsInfo item : res0) {
//            res.setWorkRelationsInfo(item);
//        }
//        SearchBelongWorkSpotRes res = new SearchBelongWorkSpotRes(res0);
        
//        res.setTestStr("123");
        
        return new BaseResponse<SearchBelongWorkSpotRes>(RtnCode.INSERT_SUCCESSFUL.getCode(),RtnCode.INSERT_SUCCESSFUL.getMessage(), res);
    }
    
}
