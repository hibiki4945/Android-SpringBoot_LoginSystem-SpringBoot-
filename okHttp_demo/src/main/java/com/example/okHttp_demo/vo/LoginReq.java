package com.example.okHttp_demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginReq {
    
    @JsonProperty("employee_id")
    private String employeeId;
    
    private String password;

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

}
