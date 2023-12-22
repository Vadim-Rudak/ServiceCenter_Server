package com.example.sc.maper;

import com.example.sc.entity.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMaper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setInfoclient_id(rs.getInt("infoclient_id"));
        client.setSurname(rs.getString("surname"));
        client.setName(rs.getString("name"));
        client.setPatronymic(rs.getString("patronymic"));
        client.setAddress(rs.getString("address"));
        client.setPhone_number(rs.getInt("phonenumber"));
        return client;
    }

}
