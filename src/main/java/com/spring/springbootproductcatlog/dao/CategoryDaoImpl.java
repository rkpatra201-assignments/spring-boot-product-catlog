package com.spring.springbootproductcatlog.dao;

import com.spring.springbootproductcatlog.model.Category;
import com.spring.springbootproductcatlog.mappers.CategoryRecordMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl extends GenericDao<Category,Integer> {

    private static final String SELECT_ALL = "SELECT * FROM TBl_CATEGORY";

    @Override
    public Category insert(Category category) {
        return null;
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public Category deleteById(Integer id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return getJdbcTemplate().query(SELECT_ALL, new CategoryRecordMapper());
    }
}
