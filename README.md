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

## About me
I'm Sandra Campos, Software Engineer since almost 10 years in many languages (Java, PHP, GoLang). [Here](https://www.linkedin.com/in/sandra-campos-buil-73bb82a4/) is my LinkedIn in case you want to know more about me.
Do not hesitate to contact me in case of there are doubts about the code. It's quite simple but I know everything could be better with more and more time to develop it ;-)