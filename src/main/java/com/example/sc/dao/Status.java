package com.example.sc.dao;



import java.util.List;

public interface Status {

    void save(com.example.sc.entity.Status status);

    com.example.sc.entity.Status getById(int id);

    List<com.example.sc.entity.Status> findAll();

    void update(com.example.sc.entity.Status status);

    void delete(int id);
}
