package com.example.sc.dao;

import com.example.sc.maper.StatusMaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StatusImpl implements Status {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public StatusImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(com.example.sc.entity.Status status) {
        String sql = "INSERT INTO status (status_id, info_status) VALUES (?,?)";
        jdbcTemplate.update(sql, status.getStatus_id(), status.getInfo_status());
    }

    @Override
    public com.example.sc.entity.Status getById(int id) {
        String sql = "SELECT * FROM status WHERE status_id=?";
        return jdbcTemplate.queryForObject(sql, new StatusMaper(), id);
    }

    @Override
    public List<com.example.sc.entity.Status> findAll() {
        String sql = "SELECT * FROM status";
        return jdbcTemplate.query(sql, new StatusMaper());
    }

    @Override
    public void update(com.example.sc.entity.Status status) {
        String sql ="UPDATE status SET info_status=? WHERE status_id=?";
        jdbcTemplate.update(sql, status.getInfo_status(), status.getStatus_id());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM status WHERE status_id=?";
        jdbcTemplate.update(sql, id);
    }
}
