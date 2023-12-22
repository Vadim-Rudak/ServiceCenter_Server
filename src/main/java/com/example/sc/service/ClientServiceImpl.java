package com.example.sc.service;

import com.example.sc.dao.InfoClient;
import com.example.sc.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    public InfoClient infoClient;

    @Override
    public void save(Client client) {
        this.infoClient.save(client);
    }

    @Override
    public Client getById(int id) {
        return infoClient.getById(id);
    }

    @Override
    public List<Client> findAll() {
        return infoClient.findAll();
    }

    @Override
    public void update(Client client) {
        this.infoClient.update(client);
    }

    @Override
    public void delete(int id) {
        infoClient.delete(id);
    }
}
