package com.spring.springbootproductcatlog.mappers;

import com.spring.springbootproductcatlog.model.Brand;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BrandRecordRowMapper implements RowMapper<Brand> {

    @Override
    public Brand mapRow(ResultSet rs, int i) throws SQLException {
        Brand brand = new Brand();
        brand.setId(rs.getInt("ID"));
        brand.setName(rs.getString("NAME"));
        return brand;
    }
}
