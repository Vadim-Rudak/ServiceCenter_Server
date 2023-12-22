package com.example.sc.service;

import com.example.sc.entity.Details;

import java.util.List;

public interface DetailService {
    void save(Details details);

    Details getById(int id);

    List<Details> getByOrdId(int id);

    List<Details> findAll();

    void update(Details details);

    void delete(int id);
}
