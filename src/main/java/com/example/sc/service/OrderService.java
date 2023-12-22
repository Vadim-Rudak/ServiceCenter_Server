package com.example.sc.service;

import com.example.sc.entity.Ord;

import java.util.List;

public interface OrderService {
    void save(Ord ord);

    Ord getById(int id);

    List<Ord> findAll();

    void update(Ord ord);

    void delete(int id);
}
