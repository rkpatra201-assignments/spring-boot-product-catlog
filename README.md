# spring-boot-product-catlog

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
