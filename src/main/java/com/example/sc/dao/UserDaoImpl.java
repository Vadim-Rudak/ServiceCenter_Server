package com.example.sc.dao;

import com.example.sc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao{

    JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO usr (name,password,active,roles) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, user.getName(),user.getPassword(),user.isActive(),user.getRoles());
    }

}
