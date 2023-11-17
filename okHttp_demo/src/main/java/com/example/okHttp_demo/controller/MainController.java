package com.example.okHttp_demo.controller;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.service.ifs.MainService;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.LoginReq;
import com.example.okHttp_demo.vo.LoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class MainController {

    @Autowired
    private MainService mService;
    
//    @PostMapping("/login")
//    public String getUserInfo2()
//    {
//        System.out.println("123");
//
//        return "user_info";
//    }
    
    @PostMapping("/login")
    public BaseResponse<LoginRes> Login(@RequestBody LoginReq req)
    {
        System.out.println("123");
        
        BaseResponse<LoginRes> res = mService.Login(req.getAccount(), req.getPassword());
        
        if(!res.getStatus().matches("200")) {
            return new BaseResponse<LoginRes>(
                    RtnCode.FAILED.getCode(),
                    RtnCode.FAILED.getMessage(),
                    null);
        }

        System.out.println("ok");
        
        return new BaseResponse<LoginRes>(
                RtnCode.SUCCESSFUL.getCode(),
                RtnCode.SUCCESSFUL.getMessage(), 
                res.getData());
    }
    
}
