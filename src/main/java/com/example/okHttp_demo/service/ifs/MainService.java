package com.example.okHttp_demo.service.ifs;

import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.LoginRes;

public interface MainService {

    public BaseResponse<LoginRes> Login(String account, String password);
    
}
