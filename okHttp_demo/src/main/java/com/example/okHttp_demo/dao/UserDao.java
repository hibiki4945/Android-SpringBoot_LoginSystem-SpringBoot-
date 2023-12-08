package com.example.okHttp_demo.dao;

import com.example.okHttp_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 作成者:許智偉 日付 2023/11/20
 */
public interface UserDao extends JpaRepository<User, String>{

}
