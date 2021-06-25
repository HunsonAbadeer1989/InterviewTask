CREATE TABLE provider (
     id BIGINT NOT NULL AUTO_INCREMENT,
     name VARCHAR(500),
     PRIMARY KEY (id)
     );

CREATE TABLE supply (
     id BIGINT NOT NULL AUTO_INCREMENT,
     provider_id BIGINT,
     date_of_supply DATETIME,
     PRIMARY KEY (id)
     );

CREATE TABLE product (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    type VARCHAR(255),
    weight FLOAT,
    price FLOAT,
    PRIMARY KEY (id)
    );

CREATE TABLE supply_product (
    id BIGINT NOT NULL AUTO_INCREMENT,
    supply_id BIGINT,
    product_id BIGINT,
    PRIMARY KEY (id)
    );