package com.example.sc.dao;

import com.example.sc.entity.Ord;

import java.util.List;

public interface Order {

    void save(Ord ord);

    Ord getById(int id);

    List<Ord> findAll();

    void update(Ord ord);

    void delete(int id);
}
