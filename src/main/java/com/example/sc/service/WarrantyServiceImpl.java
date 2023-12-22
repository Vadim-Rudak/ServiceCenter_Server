package com.example.sc.service;

import com.example.sc.dao.Warrantys;
import com.example.sc.entity.Warranty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyServiceImpl implements WarrantyService {

    @Autowired
    public Warrantys warrantys;

    @Override
    public void save(Warranty warranty) {
        warrantys.save(warranty);
    }

    @Override
    public Warranty getById(int id) {
        return warrantys.getById(id);
    }

    @Override
    public List<Warranty> findAll() {
        return warrantys.findAll();
    }

    @Override
    public void update(Warranty warranty) {
        warrantys.update(warranty);
    }

    @Override
    public void delete(int id) {
        warrantys.delete(id);
    }
}
