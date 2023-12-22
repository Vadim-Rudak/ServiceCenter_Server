package com.example.sc.service;

import com.example.sc.dao.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    public Status status;

    @Override
    public void save(com.example.sc.entity.Status status) {
        this.status.save(status);
    }

    @Override
    public com.example.sc.entity.Status getById(int id) {
        return status.getById(id);
    }

    @Override
    public List<com.example.sc.entity.Status> findAll() {
        return status.findAll();
    }

    @Override
    public void update(com.example.sc.entity.Status status) {
        this.status.update(status);
    }

    @Override
    public void delete(int id) {
        status.delete(id);
    }
}
