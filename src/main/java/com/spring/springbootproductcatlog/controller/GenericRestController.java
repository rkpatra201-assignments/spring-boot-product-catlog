package com.spring.springbootproductcatlog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class GenericRestController<T,I> {

    public abstract ResponseEntity<T> create(@RequestBody T body);
    public abstract ResponseEntity<T> update(@RequestBody T body, @PathVariable I id);
    public abstract ResponseEntity<T> delete(@PathVariable I id);
    public abstract ResponseEntity<T> get(@PathVariable I id);
    public abstract ResponseEntity<List<T>> getList();

}
