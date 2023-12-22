package com.example.sc.maper;

import com.example.sc.entity.Client;
import com.example.sc.entity.Ord;
import com.example.sc.entity.Status;
import com.example.sc.entity.Warranty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdMaper implements RowMapper<Ord> {

    @Override
    public Ord mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ord ord1 = new Ord();
        ord1.setId(rs.getInt("ord_id"));
        ord1.setName_ord(rs.getString("name_ord"));
        ord1.setDate_add_ord(rs.getString("date_add_ord"));
        ord1.setPrice(rs.getInt("price"));
        ord1.setBreakdown_info(rs.getString("breakdown_info"));

        return ord1;
    }

//    @Override
//    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//        User user = new User();
//        user.setId(rs.getInt("id"));
//        user.setName(rs.getString("name"));
//        user.setEmail(rs.getString("email"));
//        return user;
//    }
}
