package com.example.okHttp_demo.vo;

public class LoginRes {

  private String account;
  
  private String password;
  
  private String name;

public String getAccount() {
    return account;
}

public void setAccount(String account) {
    this.account = account;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public LoginRes() {
    super();
    // TODO Auto-generated constructor stub
}

public LoginRes(String account, String password, String name) {
    super();
    this.account = account;
    this.password = password;
    this.name = name;
}

}
