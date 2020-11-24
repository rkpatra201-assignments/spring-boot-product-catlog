package com.spring.springbootproductcatlog.dao;

import com.spring.springbootproductcatlog.model.Brand;
import com.spring.springbootproductcatlog.model.Product;
import com.spring.springbootproductcatlog.model.response.GroupProductCountBySeller;
import com.spring.springbootproductcatlog.mappers.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl extends GenericDao<Product, Integer> {


    private static final String INSERT_PRODUCT = "INSERT INTO TBL_PRODUCT(SKU,NAME, PRICE, COLOR_NAME, PRODUCT_SIZE, STATUS, CATEGORY_ID, BRAND_ID, SELLER_ID) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_SKU = "SELECT P.ID,P.SKU,P.NAME,P.PRICE,P. COLOR_NAME, P.PRODUCT_SIZE, P.STATUS ,\n" +
            "C.ID AS CID, C.NAME AS CNAME, B.ID AS BID, B.NAME AS BNAME, S.ID AS SID, S.NAME AS SNAME\n" +
            "FROM TBL_PRODUCT P \n" +
            "JOIN TBL_BRAND B \n" +
            "ON B.ID=P.BRAND_ID \n" +
            "JOIN TBL_SELLER S\n" +
            "ON S.ID=P.SELLER_ID\n" +
            "JOIN TBL_CATEGORY C\n" +
            "ON C.ID=P.CATEGORY_ID\n" +
            "AND P.SKU=? GROUP BY \n" +
            "P.ID,B.ID,S.ID,C.ID;";

    private static final String SELECT_COUNT_GROUP_BY_SELLER = "SELECT  P.SELLER_ID AS SID,S.NAME AS SNAME,COUNT(P.ID) PCOUNT FROM TBL_PRODUCT P\n" +
            "JOIN TBL_SELLER S\n" +
            "ON S.ID=P.SELLER_ID\n" +
            "GROUP BY SELLER_ID";

    private static final String SELECT_GROUP_BY_BRAND = "SELECT P.ID,P.SKU,P.NAME,P.PRICE,P. COLOR_NAME, P.PRODUCT_SIZE, P.STATUS ,\n" +
            "C.ID AS CID, C.NAME AS CNAME, B.ID AS BID, B.NAME AS BNAME, S.ID AS SID, S.NAME AS SNAME\n" +
            "FROM TBL_PRODUCT P \n" +
            "JOIN TBL_BRAND B \n" +
            "ON B.ID=P.BRAND_ID \n" +
            "JOIN TBL_SELLER S\n" +
            "ON S.ID=P.SELLER_ID\n" +
            "JOIN TBL_CATEGORY C\n" +
            "ON C.ID=P.CATEGORY_ID\n" +
            "GROUP BY \n" +
            "B.ID,\n" +
            "P.ID,B.ID,S.ID,C.ID;";

    private static final String SELECT_GROUP_BY_COLOR = "SELECT P.ID,P.SKU,P.NAME,P.PRICE,P. COLOR_NAME, P.PRODUCT_SIZE, P.STATUS ,\n" +
            "C.ID AS CID, C.NAME AS CNAME, B.ID AS BID, B.NAME AS BNAME, S.ID AS SID, S.NAME AS SNAME\n" +
            "FROM TBL_PRODUCT P \n" +
            "JOIN TBL_BRAND B \n" +
            "ON B.ID=P.BRAND_ID \n" +
            "JOIN TBL_SELLER S\n" +
            "ON S.ID=P.SELLER_ID\n" +
            "JOIN TBL_CATEGORY C\n" +
            "ON C.ID=P.CATEGORY_ID\n" +
            "GROUP BY \n" +
            "P.COLOR_NAME,\n" +
            "P.ID,B.ID,S.ID,C.ID;";

    private static final String SELECT_GROUP_BY_SIZE = "SELECT P.ID,P.SKU,P.NAME,P.PRICE,P. COLOR_NAME, P.PRODUCT_SIZE, P.STATUS ,\n" +
            "C.ID AS CID, C.NAME AS CNAME, B.ID AS BID, B.NAME AS BNAME, S.ID AS SID, S.NAME AS SNAME\n" +
            "FROM TBL_PRODUCT P \n" +
            "JOIN TBL_BRAND B \n" +
            "ON B.ID=P.BRAND_ID \n" +
            "JOIN TBL_SELLER S\n" +
            "ON S.ID=P.SELLER_ID\n" +
            "JOIN TBL_CATEGORY C\n" +
            "ON C.ID=P.CATEGORY_ID\n" +
            "GROUP BY \n" +
            "P.PRODUCT_SIZE,\n" +
            "P.ID,B.ID,S.ID,C.ID;";


    @Override
    public Product insert(Product p) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        getJdbcTemplate().update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(INSERT_PRODUCT, new String[]{"ID"});
                    ps.setString(1, p.getSku());
                    ps.setString(2, p.getName());
                    ps.setDouble(3, p.getPrice());
                    ps.setString(4, p.getColor());
                    ps.setString(5, p.getSize());
                    ps.setString(6, p.getStatus().name());
                    ps.setInt(7, p.getCategory().getId());
                    ps.setInt(8, p.getBrand().getId());
                    ps.setInt(9, p.getSeller().getId());

                    return ps;
                }, keyHolder);

        Number key = keyHolder.getKey();
        p.setId(key.intValue());
        return p;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public Product deleteById(Integer id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }


    public Product findBySku(String sku) {
        return getJdbcTemplate().queryForObject(SELECT_ALL_SKU,new ProductRecordRowMapper(), new Object[]{sku});
    }

    public List<GroupProductCountBySeller> findCountBySellerAll() {
        return getJdbcTemplate().query(SELECT_COUNT_GROUP_BY_SELLER, new GroupProductCountBySellerRecordRowMapper());
    }


    public Map<Brand, List<Product>> getGroupByBrand() {
        return getJdbcTemplate().queryForObject(SELECT_GROUP_BY_BRAND, new GroupByBrandRowMapper());
    }

    public Map<String, List<Product>> getGroupByColor() {
        return getJdbcTemplate().queryForObject(SELECT_GROUP_BY_COLOR, new GroupByColorRowMapper());
    }

    public Map<String, List<Product>> getGroupBySize() {
        return getJdbcTemplate().queryForObject(SELECT_GROUP_BY_SIZE, new GroupBySizeRowMapper());
    }
}
