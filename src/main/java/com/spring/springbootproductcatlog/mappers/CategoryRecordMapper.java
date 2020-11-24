package com.spring.springbootproductcatlog.mappers;

import com.spring.springbootproductcatlog.model.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CategoryRecordMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int i) throws SQLException {
        Category category = new Category();
        category.setId(rs.getInt("ID"));
        category.setName(rs.getString("NAME"));
        return category;
    }
}
