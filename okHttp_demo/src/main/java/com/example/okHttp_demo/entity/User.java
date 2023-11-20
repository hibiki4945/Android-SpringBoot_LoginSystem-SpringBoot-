package com.example.okHttp_demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @Column(name = "employee_id") 
    private String employeeId;
    
    @Column(name = "password")
    private String password;

    @Column(name = "authorization_rank")
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

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(String employeeId, String password, String authorizationRank) {
        super();
        this.employeeId = employeeId;
        this.password = password;
        this.authorizationRank = authorizationRank;
    }

}
