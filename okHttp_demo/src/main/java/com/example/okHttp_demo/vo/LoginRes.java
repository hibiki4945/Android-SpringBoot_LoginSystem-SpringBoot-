package com.example.okHttp_demo.vo;

public class LoginRes {

  private String employeeId;
  
  private String password;
  
  private String authorizationRank;

public String getEmployeeId() {
    return employeeId;
}

public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getAuthorizationRank() {
    return authorizationRank;
}

public void setAuthorizationRank(String authorizationRank) {
    this.authorizationRank = authorizationRank;
}

public LoginRes() {
    super();
    // TODO Auto-generated constructor stub
}

public LoginRes(String employeeId, String password, String authorizationRank) {
    super();
    this.employeeId = employeeId;
    this.password = password;
    this.authorizationRank = authorizationRank;
}
  
}
