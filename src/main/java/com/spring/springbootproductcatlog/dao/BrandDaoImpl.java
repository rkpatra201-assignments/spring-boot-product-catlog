package com.spring.springbootproductcatlog.dao;

import com.spring.springbootproductcatlog.model.Brand;
import com.spring.springbootproductcatlog.mappers.BrandRecordRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandDaoImpl extends GenericDao<Brand,Integer> {

    private static final String SELECT_ALL = "SELECT * FROM TBl_BRAND";

    @Override
    public Brand insert(Brand brand) {
        return null;
    }

    @Override
    public Brand update(Brand brand) {
        return null;
    }

    @Override
    public Brand findById(Integer id) {
        return null;
    }

    @Override
    public Brand deleteById(Integer id) {
        return null;
    }

    @Override
    public List<Brand> findAll() {
        return getJdbcTemplate().query(SELECT_ALL, new BrandRecordRowMapper());
    }
}
