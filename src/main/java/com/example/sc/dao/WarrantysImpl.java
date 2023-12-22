package com.example.sc.dao;

import com.example.sc.entity.Warranty;
import com.example.sc.maper.WarrantyMaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class WarrantysImpl implements Warrantys {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public WarrantysImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Warranty warranty) {
        String sql = "INSERT INTO warranty (warranty_id,warranty,date_add,validity) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, warranty.getWarranty_id(), warranty.getWarranty(), warranty.getDate_add(),warranty.getValidity());
    }

    @Override
    public Warranty getById(int id) {
        String sql = "SELECT * FROM warranty WHERE warranty_id=?";
        return jdbcTemplate.queryForObject(sql, new WarrantyMaper(), id);
    }

    @Override
    public List<Warranty> findAll() {
        String sql = "SELECT * FROM warranty";
        return jdbcTemplate.query(sql, new WarrantyMaper());
    }

    @Override
    public void update(Warranty warranty) {
        String sql ="UPDATE warranty SET warranty=?,date_add=?,validity=? WHERE warranty_id=?";
        jdbcTemplate.update(sql, warranty.getWarranty(), warranty.getDate_add(),warranty.getValidity(), warranty.getWarranty_id());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM warranty WHERE warranty_id=?";
        jdbcTemplate.update(sql, id);
    }
}
