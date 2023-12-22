package com.example.sc.service;

import com.example.sc.entity.Warranty;

import java.util.List;

public interface WarrantyService {
    void save(Warranty warranty);

    Warranty getById(int id);

    List<Warranty> findAll();

    void update(Warranty warranty);

    void delete(int id);
}
