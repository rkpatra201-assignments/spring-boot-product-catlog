CREATE TABLE TBL_SELLER
(
ID INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(60),
SKU_PREFIX VARCHAR(60)
);

ALTER TABLE TBL_SELLER
ADD UNIQUE (NAME);

ALTER TABLE TBL_SELLER
ADD UNIQUE (SKU_PREFIX);

CREATE TABLE TBL_BRAND
(
ID INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(60),
UNIQUE (NAME)
);


CREATE TABLE TBL_CATEGORY
(
ID INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(60),
UNIQUE (NAME)
);


CREATE TABLE TBL_PRODUCT (

    ID INT PRIMARY KEY AUTO_INCREMENT,
    SKU VARCHAR(60),
    NAME VARCHAR(60),
    PRICE DOUBLE,
    COLOR_NAME VARCHAR(60),
    PRODUCT_SIZE VARCHAR(60),
    STATUS VARCHAR(60),

    CATEGORY_ID INT,
    BRAND_ID INT,
    SELLER_ID INT,
    FOREIGN KEY (CATEGORY_ID) REFERENCES TBL_CATEGORY(ID),
    FOREIGN KEY (BRAND_ID) REFERENCES TBL_BRAND(ID),
    FOREIGN KEY (SELLER_ID) REFERENCES TBL_SELLER(ID),
    UNIQUE(SKU)
);