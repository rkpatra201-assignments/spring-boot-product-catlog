package com.spring.springbootproductcatlog.mappers;

import com.spring.springbootproductcatlog.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupBySizeRowMapper extends ProductRowMapper implements RowMapper<Map<String, List<Product>>> {
    @Override
    public Map<String, List<Product>> mapRow(ResultSet resultSet, int i) throws SQLException {
        Map<String, List<Product>> groupBySize = new HashMap<>();
        while (resultSet.next()) {
            Product p = mapToProduct(resultSet);
            if (groupBySize.containsKey(p.getSize())) {
                groupBySize.get(p.getSize()).add(p);
            } else {
                List<Product> products = new ArrayList<>();
                products.add(p);
                groupBySize.put(p.getSize(), products);
            }
        }
        return groupBySize;
    }

}
