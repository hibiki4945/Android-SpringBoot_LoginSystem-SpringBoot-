package com.example.okHttp_demo.constants;

public enum RtnCode {

    SUCCESSFUL("200", "ログインしました"),
    ACCOUNT_NOT_EXIST_ERROR("400", "該当の社員が見当たりません"),
    PASSWORD_ERROR("400", "パスワードが間違っています");
    
    private String code;
    
    private String message;

    private RtnCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
