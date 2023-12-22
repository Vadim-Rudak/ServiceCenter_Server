package com.example.sc.maper;

import com.example.sc.entity.Warranty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WarrantyMaper implements RowMapper<Warranty> {
    @Override
    public Warranty mapRow(ResultSet rs, int rowNum) throws SQLException {
        Warranty warranty = new Warranty();
        warranty.setWarranty_id(rs.getInt("warranty_id"));
        warranty.setWarranty(rs.getString("warranty"));
        warranty.setDate_add(rs.getString("date_add"));
        warranty.setValidity(rs.getString("validity"));
        return warranty;
    }
}
