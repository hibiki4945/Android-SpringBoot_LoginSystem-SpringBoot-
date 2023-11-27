package com.example.okHttp_demo.constants;

public enum RtnCode {

    SUCCESSFUL("200", "ログインしました"),
    INSERT_SUCCESSFUL("200", "追加に成功しました"),
    ACCOUNT_NOT_EXIST_ERROR("400", "該当の社員が見当たりません"),
    PASSWORD_ERROR("400", "パスワードが間違っています"),
    INPUT_EMPTY_ERROR("400", "入力内容が欠けている"),
    TIME_INTERVAL_ERROR("400", "日付の入力内容が間違っています"),
    INSERT_ERROR("400", "追加に失敗しました"),
    SEARCHING_EMPTY("200", "検索結果なし"),
    SEARCHING_SUCCESSFUL("200", "検索結果あり");
    
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
