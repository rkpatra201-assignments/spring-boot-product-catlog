# spring-boot-product-catlog

# RUN
`mvn spring-boot:run`

# SWAGGER
* http://localhost:8080/swagger-ui.html
![image](https://user-images.githubusercontent.com/17001948/100111625-46a22100-2e94-11eb-8f7f-de63f13e0bd7.png)

## GET API
* http://localhost:8080/products/ss-xyzew
* http://localhost:8080/products/groups/color
* http://localhost:8080/products/groups/size
* http://localhost:8080/products/groups/brand
* http://localhost:8080/products/groups/seller/count

## POST

* http://localhost:8080/products/
* Request Body is below. sku is unique.

```json
{
  "id": 2,
  "sku": "ct-xyzvwt",
  "name": "Puma Dark Socks",
  "price": 210.45,
  "color": "RED",
  "size": "L",
  "status": "SALE",
  "category": {
    "id": 2,
    "name": "SOCKS"
  },
  "brand": {
    "id": 1,
    "name": "PUMA"
  },
  "seller": {
    "id": 1,
    "name": "cloudtail",
    "skuPrefix": null
  }
}
```
