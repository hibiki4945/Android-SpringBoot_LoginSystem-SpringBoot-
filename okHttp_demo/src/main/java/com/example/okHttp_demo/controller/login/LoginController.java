package com.example.okHttp_demo.controller.login;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.service.login.LoginService;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.LoginReq;
import com.example.okHttp_demo.vo.LoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作成者:許智偉
 * 日付 2023/11/20
 */
@RestController
@RequestMapping("user")
public class LoginController {

    @Autowired
    private LoginService mService;

    /**
     * ログインする。
     * 作成者:許智偉
     *
     * @param req  ログインに必要なデータ
     * @return ログインの結果
     */
    @PostMapping("/login")
    public BaseResponse<LoginRes> Login(@RequestBody LoginReq req)
    {
        
//      ログインする
        BaseResponse<LoginRes> res = mService.Login(req.getEmployeeId(), req.getPassword());
        if(!res.getStatus().matches("200")) {
            return new BaseResponse<LoginRes>(res.getStatus(),res.getMessage(),null);
        }
        
//      ログインの結果を返す
        return new BaseResponse<LoginRes>(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage(), res.getData());
    }
    
}
