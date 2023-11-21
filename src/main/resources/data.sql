 CREATE TABLE brands(
    id int NOT NULL UNIQUE,
    name varchar(20) NOT NULL,

    PRIMARY KEY(id)
);

CREATE TABLE prices(
    price_list int NOT NULL UNIQUE,
    brand_id int NOT NULL,
    start_date timestamp NOT NULL,
    end_date timestamp NOT NULL,
    product_id int NOT NULL,
    priority int NOT NULL,
    price float NOT NULL,
    curr varchar(3) NOT NULL,

    PRIMARY KEY(price_list),
    FOREIGN KEY(brand_id) REFERENCES brands(id)
);

INSERT INTO brands (id, name) VALUES (1,'ZARA');
INSERT INTO brands (id, name) VALUES (2,'MANGO');
INSERT INTO prices (brand_id,start_date,end_date,price_list,product_id,priority,price,curr) VALUES(1,'2020-06-14 00.00.00','2020-12-31 23.59.59',1,35455,0,35.50,'EUR');
INSERT INTO prices (brand_id,start_date,end_date,price_list,product_id,priority,price,curr) VALUES(1,'2020-06-14 15.00.00','2020-06-14 18.30.00',2,35455,1,25.45,'EUR');
INSERT INTO prices (brand_id,start_date,end_date,price_list,product_id,priority,price,curr) VALUES(1,'2020-06-15 00.00.00','2020-06-15 11.00.00',3,35455,1,30.50,'EUR');
INSERT INTO prices (brand_id,start_date,end_date,price_list,product_id,priority,price,curr) VALUES(1,'2020-06-15 16.00.00','2020-12-31 23.59.59',4,35455,1,38.95,'EUR');
INSERT INTO prices (brand_id,start_date,end_date,price_list,product_id,priority,price,curr) VALUES(1,'2020-06-14 00.00.00','2020-12-31 23.59.59',5,55555,0,99.99,'EUR');
INSERT INTO prices (brand_id,start_date,end_date,price_list,product_id,priority,price,curr) VALUES(2,'2020-06-14 00.00.00','2020-12-31 23.59.59',6,11111,0,1.00,'EUR');