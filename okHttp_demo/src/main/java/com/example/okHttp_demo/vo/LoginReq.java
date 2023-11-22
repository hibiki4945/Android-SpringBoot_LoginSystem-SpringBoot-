package com.example.okHttp_demo.vo;

public class LoginReq {
    
//    @JsonProperty("personalNo")
    private String personalNo;
    
    private String password;

    public String getPersonalNo() {
        return personalNo;
    }

    public void setPersonalNo(String personalNo) {
        this.personalNo = personalNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
