package com.example.okHttp_demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @Column(name = "PERSONAL_NO") 
    private String personalNo;
    
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "APP_AUTHORITY")
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

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(String personalNo, String password, String appAuthority) {
        super();
        this.personalNo = personalNo;
        this.password = password;
        this.appAuthority = appAuthority;
    }

}
