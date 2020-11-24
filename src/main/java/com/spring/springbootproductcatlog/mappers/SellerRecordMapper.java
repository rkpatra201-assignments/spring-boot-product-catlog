package com.spring.springbootproductcatlog.mappers;

import com.spring.springbootproductcatlog.model.Seller;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SellerRecordMapper implements RowMapper<Seller> {
    @Override
    public Seller mapRow(ResultSet rs, int i) throws SQLException {
        Seller seller = new Seller();
        seller.setId(rs.getInt("ID"));
        seller.setName(rs.getString("NAME"));
        seller.setSkuPrefix(rs.getString("SKU_PREFIX"));
        return seller;
    }
}
