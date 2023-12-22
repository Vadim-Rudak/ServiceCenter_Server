package com.example.sc.dao;

import com.example.sc.entity.Ord;
import com.example.sc.maper.OrderMaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderImpl implements Order {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Ord ord) {
        String sql = "INSERT INTO ord (ord_id,name_ord,date_add_ord,price,breakdown_info,status_id,infoclient_id,warranty_id) VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,ord.getId(), ord.getName_ord(),ord.getDate_add_ord(),ord.getPrice(),ord.getBreakdown_info(),
                ord.getStatus_id(),ord.getInfoclient_id(),ord.getWarranty_id());
    }

    @Override
    public Ord getById(int id) {
        String sql = "SELECT * FROM ord JOIN status ON ord.status_id = status.status_id" +
                " JOIN infoclient ON ord.infoclient_id = infoclient.infoclient_id " +
                " JOIN warranty ON ord.warranty_id = warranty.warranty_id WHERE ord_id=?";
        return jdbcTemplate.queryForObject(sql, new OrderMaper(), id);
    }

    @Override
    public List<Ord> findAll() {
        String sql = "SELECT * FROM ord JOIN status ON ord.status_id = status.status_id" +
                " JOIN infoclient ON ord.infoclient_id = infoclient.infoclient_id " +
                " JOIN warranty ON ord.warranty_id = warranty.warranty_id";
        return jdbcTemplate.query(sql, new OrderMaper());
    }

    @Override
    public void update(Ord ord) {
        String sql ="UPDATE ord SET name_ord=?,date_add_ord=?,price=?,breakdown_info=?,status_id=?,infoclient_id=?,warranty_id=? WHERE ord_id=?";
        jdbcTemplate.update(sql, ord.getName_ord(),ord.getDate_add_ord(),ord.getPrice(),ord.getBreakdown_info(),
                ord.getStatus_id(),ord.getInfoclient_id(),ord.getWarranty_id(),ord.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE ord, status, warranty, infoclient FROM ord INNER JOIN status INNER JOIN warranty INNER JOIN infoclient" +
                " WHERE ord.status_id = status.status_id AND ord.warranty_id = warranty.warranty_id AND ord.infoclient_id = infoclient.infoclient_id AND ord.ord_id=?";
        jdbcTemplate.update(sql, id);
    }
}
