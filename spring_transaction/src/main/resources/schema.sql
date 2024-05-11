create table if not exists Products
(
    prod_id     INT AUTO_INCREMENT        PRIMARY KEY,
    prod_name   VARCHAR(255)                NOT NULL,
    prod_price  INT                         NOT NULL
);