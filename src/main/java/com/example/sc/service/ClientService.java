package com.example.sc.service;

import com.example.sc.entity.Client;

import java.util.List;

public interface ClientService {
    void save(Client client);

    Client getById(int id);

    List<Client> findAll();

    void update(Client client);

    void delete(int id);
}
