package com.spring.springbootproductcatlog.controller;

import com.spring.springbootproductcatlog.model.Product;
import com.spring.springbootproductcatlog.dao.ProductDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController extends GenericRestController<Product,Integer> {


    @Autowired
    private ProductDaoImpl productDao;
    @PostMapping("/")
    @Override
    public ResponseEntity<Product> create(Product body) {
        Product saved = productDao.insert(body);
        return ResponseEntity.ok(saved);
    }

    @Override
    public ResponseEntity<Product> update(Product body, Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Product> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Product> get(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Product>> getList() {
        return null;
    }
}
