package com.example.sc.dao;

import com.example.sc.entity.Details;

import java.util.List;

public interface Detail {

    void save(Details details);

    Details getById(int id);

    List<Details> getByOrdId(int id);

    List<Details> findAll();

    void update(Details details);

    void delete(int id);
}
