package com.spring.springbootproductcatlog.model.response;

import com.spring.springbootproductcatlog.model.Brand;

public class GroupByBrand extends ProductGroupBy{

    private Brand brand;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
