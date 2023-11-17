package com.example.okHttp_demo.service.impl;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.entity.User;
import com.example.okHttp_demo.repository.UserDao;
import com.example.okHttp_demo.service.ifs.MainService;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.LoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainImpl implements MainService{

    @Autowired
    private UserDao uDao;
    
    @Override
    public BaseResponse<LoginRes> Login(String account, String password) {
        
        if(!uDao.existsById(account)) {
            return new BaseResponse<LoginRes>(RtnCode.FAILED.getCode(), RtnCode.FAILED.getMessage(), null);
        }
        Optional<User> res0 = uDao.findById(account);
        User res = res0.get();
        if(!res.getPassword().matches(password)) {
            return new BaseResponse<LoginRes>(RtnCode.FAILED.getCode(), RtnCode.FAILED.getMessage(), null);
        }
        LoginRes loginRes = new LoginRes(res.getAccount(), res.getPassword(), res.getName());
        return new BaseResponse<LoginRes>(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), loginRes);
        
    }

}
