package com.example.sc.maper;

import com.example.sc.entity.Client;
import com.example.sc.entity.Ord;
import com.example.sc.entity.Status;
import com.example.sc.entity.Warranty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMaper implements RowMapper<Ord> {

    @Override
    public Ord mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ord ord1 = new Ord();
        ord1.setId(rs.getInt("ord_id"));
        ord1.setName_ord(rs.getString("name_ord"));
        ord1.setDate_add_ord(rs.getString("date_add_ord"));
        ord1.setPrice(rs.getInt("price"));
        ord1.setBreakdown_info(rs.getString("breakdown_info"));
        ord1.setStatus_id(rs.getInt("status_id"));
        ord1.setInfoclient_id(rs.getInt("infoclient_id"));
        ord1.setWarranty_id(rs.getInt("warranty_id"));
        Status status = new Status();
        status.setStatus_id(rs.getInt("status_id"));
        status.setInfo_status(rs.getString("info_status"));
        ord1.setStatus(status);
        Client client = new Client();
        client.setInfoclient_id(rs.getInt("infoclient_id"));
        client.setName(rs.getString("name"));
        client.setSurname(rs.getString("surname"));
        client.setPatronymic(rs.getString("patronymic"));
        client.setAddress(rs.getString("address"));
        client.setPhone_number(rs.getInt("phonenumber"));
        ord1.setClient(client);
        Warranty warranty = new Warranty();
        warranty.setWarranty_id(rs.getInt("warranty_id"));
        warranty.setWarranty(rs.getString("warranty"));
        warranty.setDate_add(rs.getString("date_add"));
        warranty.setValidity(rs.getString("validity"));
        ord1.setWarranty(warranty);
        return ord1;
    }
}
