package com.spring.springbootproductcatlog.controller;

import com.spring.springbootproductcatlog.model.Brand;
import com.spring.springbootproductcatlog.model.Product;
import com.spring.springbootproductcatlog.model.response.GroupByBrand;
import com.spring.springbootproductcatlog.model.response.GroupByColor;
import com.spring.springbootproductcatlog.model.response.GroupBySize;
import com.spring.springbootproductcatlog.dao.ProductDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/products/")
@RestController
public class ProductResultController {

    @Autowired
    private ProductDaoImpl productDao;

    @GetMapping("/{sku}")
    public Object getBySku(@PathVariable String sku) {
        return productDao.findBySku(sku);
    }

    @GetMapping("/groups/seller/count")
    public Object groupCountBySeller()
    {
        return productDao.findCountBySellerAll();
    }

    @GetMapping("/groups/brand")
    public Object groupByBrand() {
        Map<Brand, List<Product>> map = productDao.getGroupByBrand();

        return map.entrySet().stream().map(e -> {
            GroupByBrand groupByBrand = new GroupByBrand();
            groupByBrand.setBrand(e.getKey());
            groupByBrand.setProductList(e.getValue());
            return groupByBrand;
        }).collect(Collectors.toList());
    }

    @GetMapping("/groups/color")
    public Object groupByColor() {
        Map<String, List<Product>> map = productDao.getGroupByColor();

        return map.entrySet().stream().map(e -> {
            GroupByColor group = new GroupByColor();
            group.setColor(e.getKey());
            group.setProductList(e.getValue());
            return group;
        }).collect(Collectors.toList());
    }

    @GetMapping("/groups/size")
    public Object groupBySize() {
        Map<String, List<Product>> map = productDao.getGroupBySize();
        return map.entrySet().stream().map(e -> {
            GroupBySize group = new GroupBySize();
            group.setSize(e.getKey());
            group.setProductList(e.getValue());
            return group;
        }).collect(Collectors.toList());
    }
}
