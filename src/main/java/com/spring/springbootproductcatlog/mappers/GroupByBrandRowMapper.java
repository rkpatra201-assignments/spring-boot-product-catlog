package com.spring.springbootproductcatlog.mappers;

import com.spring.springbootproductcatlog.model.Brand;
import com.spring.springbootproductcatlog.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class GroupByBrandRowMapper extends ProductRowMapper implements RowMapper<Map<Brand, List<Product>>> {
    @Override
    public Map<Brand, List<Product>> mapRow(ResultSet resultSet, int i) throws SQLException {
        Map<Brand, List<Product>> groupByBrand = new HashMap<>();
        while (resultSet.next()) {
            Product p = mapToProduct(resultSet);
            if (groupByBrand.containsKey(p.getBrand())) {
                groupByBrand.get(p.getBrand()).add(p);
            } else {
                List<Product> products = new ArrayList<>();
                products.add(p);
                groupByBrand.put(p.getBrand(), products);
            }
        }
        return groupByBrand;
    }

}
