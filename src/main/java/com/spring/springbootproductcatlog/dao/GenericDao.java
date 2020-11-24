package com.spring.springbootproductcatlog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public abstract class GenericDao<T, I> {

    public abstract T insert(T t);
    public abstract T update(T t);
    public abstract T findById(I id);
    public abstract T deleteById(I id);
    public abstract List<T> findAll();

    @Autowired
    private JdbcTemplate jdbcTemplate;
    protected JdbcTemplate getJdbcTemplate()
    {
        return jdbcTemplate;
    }
    
}
