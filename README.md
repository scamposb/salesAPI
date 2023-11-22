# SalesAPI

This is an API to manage prices in the Inditex Stores

## Requirements

- Java 8 or higher
- SpringBoot 3
- Maven

## API Guide

| Method | Endpoint               | Description                |
|--------|------------------------|----------------------------|
| GET    | `/api/price`          | Get price for a certain product in a certain date |

### Query params
- product_id: Product identificator (long)
- brand_id: Brand identificator (int)
- request_date: Date which we need the product price (Date)

### Output example (200 OK)
```
{
    "productID": 35455,
    "brandID": 1,
    "fee": 4,
    "startDate": "2020-06-15-16.00.00",
    "endDate": "2020-12-31-23.59.59",
    "price": 38.95
}
```