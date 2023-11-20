package com.example.okHttp_demo.service.login;

import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.LoginRes;

/**
 * 作成者:許智偉 日付 2023/11/20
 */
public interface LoginService {

    /**
     * ログインユーザーが存在するかどうかを確認し、パスワードを確認し、ログイン結果を返する。 作成者:許智偉
     *
     * @param account 社員番号
     * @param password パスワード
     * @return ログイン結果
     */
    public BaseResponse<LoginRes> Login(String account, String password);
    
}
