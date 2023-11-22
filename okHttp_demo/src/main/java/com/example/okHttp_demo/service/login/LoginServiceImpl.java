package com.example.okHttp_demo.service.login;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.dao.UserDao;
import com.example.okHttp_demo.entity.User;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.LoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 作成者:許智偉 日付 2023/11/20
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserDao uDao;

    /**
     * ログインユーザーが存在するかどうかを確認し、パスワードを確認し、ログイン結果を返する。 作成者:許智偉
     *
     * @param account 社員番号
     * @param password パスワード
     * @return ログイン結果
     */
    @Override
    public BaseResponse<LoginRes> Login(String account, String password) {
        
//      アカウントの存在を確認
        if(!uDao.existsById(account)) {
            return new BaseResponse<LoginRes>(RtnCode.ACCOUNT_NOT_EXIST_ERROR.getCode(), RtnCode.ACCOUNT_NOT_EXIST_ERROR.getMessage(), null);
        }
        
//      アカウントの詳細を探す
        Optional<User> res0 = uDao.findById(account);
        User res = res0.get();
        
//      パスワードを確認
        if(!res.getPassword().matches(password)) {
            return new BaseResponse<LoginRes>(RtnCode.PASSWORD_ERROR.getCode(), RtnCode.PASSWORD_ERROR.getMessage(), null);
        }
        
//      ログイン結果を返す
        LoginRes loginRes = new LoginRes(res.getPersonalNo(), res.getPassword(), res.getAppAuthority());
        return new BaseResponse<LoginRes>(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), loginRes);
        
    }

}
