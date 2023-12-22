package com.example.sc.service;

import com.example.sc.dao.Detail;
import com.example.sc.entity.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    public Detail detail;

    @Override
    public void save(Details details) {
        detail.save(details);
    }

    @Override
    public Details getById(int id) {
        return detail.getById(id);
    }

    @Override
    public List<Details> getByOrdId(int id) {
        return detail.getByOrdId(id);
    }

    @Override
    public List<Details> findAll() {
        return detail.findAll();
    }

    @Override
    public void update(Details details) {
        detail.update(details);
    }

    @Override
    public void delete(int id) {
        detail.delete(id);
    }
}
