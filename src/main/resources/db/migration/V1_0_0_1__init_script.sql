CREATE SEQUENCE IF NOT EXISTS hibernate_sequence start 1000 increment 1;

CREATE TABLE IF NOT EXISTS Shop
(
    id            serial PRIMARY KEY,
    name          varchar(255) NOT NULL,
    creation_date date         NOT NULL,
    month_profit  integer,
    status        varchar(20)  NOT NULL DEFAULT 'OPEN'
);

CREATE TABLE IF NOT EXISTS Product
(
    id              serial PRIMARY KEY,
    name            varchar(1000) NOT NULL,
    cost            integer       NOT NULL,
    vat             integer       NOT NULL,
    production_date date          NOT NULL,
    expiration_date date          NOT NULL
);

CREATE TABLE IF NOT EXISTS Warehouse
(
    id         serial PRIMARY KEY,
    shop_id    int8,
    product_id int8,
    residue    integer NOT NULL DEFAULT 0,
    FOREIGN KEY (shop_id) REFERENCES Shop (id),
    FOREIGN KEY (product_id) REFERENCES Product (id)
);