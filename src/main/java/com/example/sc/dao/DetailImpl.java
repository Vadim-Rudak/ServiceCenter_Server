package com.example.sc.dao;

import com.example.sc.entity.Details;
import com.example.sc.maper.DetailsMaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DetailImpl implements Detail {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public DetailImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Details details) {
        String sql = "INSERT INTO details (details_id,name_detail,price_detail,ord_id) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, details.getDetails_id(),details.getName_detail(), details.getPrice_detail(), details.getOrd_id());
    }

    @Override
    public Details getById(int id) {
        String sql = "SELECT * FROM details WHERE details_id=?";
        return jdbcTemplate.queryForObject(sql, new DetailsMaper(), id);
    }

    @Override
    public List<Details> getByOrdId(int id) {
        String sql = "SELECT * FROM details WHERE ord_id=?";
        return jdbcTemplate.query(sql, new DetailsMaper(), id);
    }

    @Override
    public List<Details> findAll() {
        String sql = "SELECT * FROM details";
        return jdbcTemplate.query(sql, new DetailsMaper());
    }

    @Override
    public void update(Details details) {
        String sql ="UPDATE details SET name_detail=?,price_detail=?,ord_id=? WHERE details_id=?";
        jdbcTemplate.update(sql, details.getName_detail(), details.getPrice_detail(), details.getOrd_id(), details.getDetails_id());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM details WHERE details_id=?";
        jdbcTemplate.update(sql, id);
    }
}
