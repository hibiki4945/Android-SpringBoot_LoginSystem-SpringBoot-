package com.example.okHttp_demo.controller.work_relations;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.entity.WorkSpotInfo;
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

/**
 * 作成者:許智偉
 * 日付 2023/12/8
 */
@RestController
@RequestMapping("user")
public class WorkRelationsController {

    @Autowired
    private WorkRelationsSevice wService;

    /**
     * 自分の担当現場を検索する。
     * 作成者:許智偉
     *
     * @param req  検索に必要なデータ
     * @return 自分の担当現場
     */
    @PostMapping("/search_belong_work_spot")
    public BaseResponse<SearchBelongWorkSpotRes> SearchBelongWorkSpot(@RequestBody SearchBelongWorkSpotReq req)
    {
//      自分の担当現場を検索
        List<WorkSpotInfo> res0 = wService.SearchBelongWorkSpot(req.getPersonalNo());
//      検索結果の処理
        SearchBelongWorkSpotRes res = new SearchBelongWorkSpotRes(res0);
        
//      自分の担当現場を返す
        return new BaseResponse<SearchBelongWorkSpotRes>(RtnCode.INSERT_SUCCESSFUL.getCode(),RtnCode.INSERT_SUCCESSFUL.getMessage(), res);
    }
    
}
