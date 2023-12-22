package com.example.sc.maper;

import com.example.sc.entity.Status;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusMaper implements RowMapper<Status> {
    @Override
    public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
        Status status = new Status();
        status.setStatus_id(rs.getInt("status_id"));
        status.setInfo_status(rs.getString("info_status"));
        return status;
    }
}
