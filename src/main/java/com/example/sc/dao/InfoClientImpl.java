package com.example.sc.dao;

import com.example.sc.entity.Client;
import com.example.sc.maper.ClientMaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class InfoClientImpl implements InfoClient {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public InfoClientImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Client client) {
        String sql = "INSERT INTO infoclient (infoclient_id,surname, name, patronymic, address, phonenumber) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, client.getInfoclient_id(), client.getSurname(), client.getName(), client.getPatronymic(),client.getAddress(),
                client.getPhone_number());
    }

    @Override
    public Client getById(int id) {
        String sql = "SELECT * FROM infoclient WHERE infoclient_id=?";
        return jdbcTemplate.queryForObject(sql, new ClientMaper(), id);
    }

    @Override
    public List<Client> findAll() {
        String sql = "SELECT * FROM infoclient";
        return jdbcTemplate.query(sql, new ClientMaper());
    }

    @Override
    public void update(Client client) {
        String sql ="UPDATE infoclient SET surname=?, name=?, patronymic=?, address=?, phonenumber=? WHERE infoclient_id=?";
        jdbcTemplate.update(sql, client.getSurname(), client.getName(), client.getPatronymic(),client.getAddress(),
                client.getPhone_number(),client.getInfoclient_id());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM infoclient WHERE infoclient_id=?";
        jdbcTemplate.update(sql, id);
    }
}
