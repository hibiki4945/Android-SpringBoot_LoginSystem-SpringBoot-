package com.example.okHttp_demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @Column(name = "account") 
    private String account;
    
    @Column(name = "password")
    private String password;

    @Column(name = "name")
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

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(String account, String password, String name) {
        super();
        this.account = account;
        this.password = password;
        this.name = name;
    }

}
