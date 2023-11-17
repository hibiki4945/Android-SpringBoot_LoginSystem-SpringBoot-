package com.example.okHttp_demo.repository;

import com.example.okHttp_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String>{

}
