package com.spring.springbootproductcatlog.mappers;

import com.spring.springbootproductcatlog.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRecordRowMapper implements RowMapper<Product> {

    ProductRowMapper productRowMapper = new ProductRowMapper();
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        return productRowMapper.mapToProduct(resultSet);
    }
}
