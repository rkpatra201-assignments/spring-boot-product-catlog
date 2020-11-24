package com.spring.springbootproductcatlog.dao;

import com.spring.springbootproductcatlog.model.Seller;
import com.spring.springbootproductcatlog.mappers.SellerRecordMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SellerDaoImpl extends GenericDao<Seller, Integer> {

    private static final String SELECT_ALL = "SELECT * FROM TBl_SELLER";

    @Override
    public Seller insert(Seller seller) {
        return null;
    }

    @Override
    public Seller update(Seller seller) {
        return null;
    }

    @Override
    public Seller findById(Integer id) {
        return null;
    }

    @Override
    public Seller deleteById(Integer id) {
        return null;
    }

    @Override
    public List<Seller> findAll() {
        return getJdbcTemplate().query(SELECT_ALL, new SellerRecordMapper());
    }
}
