package com.spring.springbootproductcatlog.mappers;

import com.spring.springbootproductcatlog.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper {

    protected Product mapToProduct(ResultSet resultSet) throws SQLException {
        Product p = new Product();
        p.setId(resultSet.getInt("ID"));
        p.setSku(resultSet.getString("SKU"));
        p.setName(resultSet.getString("NAME"));
        p.setPrice(resultSet.getDouble("PRICE"));
        p.setColor(resultSet.getString("COLOR_NAME"));
        p.setSize(resultSet.getString("PRODUCT_SIZE"));
        p.setStatus(ProductStatus.valueOf(resultSet.getString("STATUS")));


        addBrand(p, resultSet);
        addSeller(p, resultSet);
        addCategory(p, resultSet);

        return p;
    }

    protected void addSeller(Product p, ResultSet rs) throws SQLException {
        Seller c = new Seller();
        p.setSeller(c);
        c.setId(rs.getInt("SID"));
        c.setName(rs.getString("SNAME"));
    }

    protected void addCategory(Product p, ResultSet rs) throws SQLException {
        Category c = new Category();
        p.setCategory(c);
        c.setId(rs.getInt("CID"));
        c.setName(rs.getString("CNAME"));
    }

    protected void addBrand(Product p, ResultSet resultSet) throws SQLException {
        Brand brand = new Brand();
        brand.setId(resultSet.getInt("BID"));
        brand.setName(resultSet.getString("BNAME"));
        p.setBrand(brand);
    }
}
