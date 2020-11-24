package com.spring.springbootproductcatlog.model.response;

import com.spring.springbootproductcatlog.model.Product;

import java.util.List;

public class ProductGroupBy {

    protected List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
