package com.example.sc.service;

import com.example.sc.entity.Status;

import java.util.List;

public interface StatusService {
    void save(Status status);

    Status getById(int id);

    List<Status> findAll();

    void update(Status status);

    void delete(int id);
}
