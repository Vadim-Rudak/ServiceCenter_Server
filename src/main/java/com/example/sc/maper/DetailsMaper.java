package com.example.sc.maper;

import com.example.sc.entity.Details;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailsMaper implements RowMapper<Details> {
    @Override
    public Details mapRow(ResultSet rs, int rowNum) throws SQLException {
        Details details = new Details();
        details.setDetails_id(rs.getInt("details_id"));
        details.setName_detail(rs.getString("name_detail"));
        details.setPrice_detail(rs.getInt("price_detail"));
        details.setOrd_id(rs.getInt("ord_id"));
        return details;
    }
}
