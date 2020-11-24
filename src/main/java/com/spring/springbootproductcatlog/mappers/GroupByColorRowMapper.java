package com.spring.springbootproductcatlog.mappers;

import com.spring.springbootproductcatlog.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupByColorRowMapper extends ProductRowMapper implements RowMapper<Map<String, List<Product>>> {
    @Override
    public Map<String, List<Product>> mapRow(ResultSet resultSet, int i) throws SQLException {
        Map<String, List<Product>> groupByColor = new HashMap<>();
        while (resultSet.next()) {
            Product p = mapToProduct(resultSet);
            if (groupByColor.containsKey(p.getColor())) {
                groupByColor.get(p.getColor()).add(p);
            } else {
                List<Product> products = new ArrayList<>();
                products.add(p);
                groupByColor.put(p.getColor(), products);
            }
        }
        return groupByColor;
    }

}
