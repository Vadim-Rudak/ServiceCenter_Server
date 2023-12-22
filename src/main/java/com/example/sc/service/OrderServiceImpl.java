package com.example.sc.service;

import com.example.sc.dao.InfoClient;
import com.example.sc.dao.Order;
import com.example.sc.entity.Ord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    public Order order;

    @Autowired
    public InfoClient infoClient;

    @Override
    public void save(Ord ord) {
        order.save(ord);
    }

    @Override
    public Ord getById(int id) {
        return order.getById(id);
    }

    @Override
    public List<Ord> findAll() {
        return order.findAll();
    }

    @Override
    public void update(Ord ord) {
        order.update(ord);
    }

    @Override
    public void delete(int id) {
        order.delete(id);
        infoClient.delete(id);
    }
}
