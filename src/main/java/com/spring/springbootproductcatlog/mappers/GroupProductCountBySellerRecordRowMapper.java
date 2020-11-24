package com.spring.springbootproductcatlog.mappers;

import com.spring.springbootproductcatlog.model.response.GroupProductCountBySeller;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GroupProductCountBySellerRecordRowMapper implements RowMapper<GroupProductCountBySeller> {

    @Override
    public GroupProductCountBySeller mapRow(ResultSet rs, int i) throws SQLException {
        GroupProductCountBySeller count = new GroupProductCountBySeller();
        count.setCount(rs.getInt("PCOUNT"));
        count.setId(rs.getInt("SID"));
        count.setName(rs.getString("SNAME"));
        return count;
    }
}
