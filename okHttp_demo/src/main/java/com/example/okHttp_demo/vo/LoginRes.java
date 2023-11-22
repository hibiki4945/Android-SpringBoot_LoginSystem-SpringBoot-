package com.example.okHttp_demo.vo;

public class LoginRes {

  private String personalNo;
  
  private String password;
  
  private String appAuthority;

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

public String getAppAuthority() {
    return appAuthority;
}

public void setAppAuthority(String appAuthority) {
    this.appAuthority = appAuthority;
}

public LoginRes() {
    super();
    // TODO Auto-generated constructor stub
}

public LoginRes(String personalNo, String password, String appAuthority) {
    super();
    this.personalNo = personalNo;
    this.password = password;
    this.appAuthority = appAuthority;
}

}
