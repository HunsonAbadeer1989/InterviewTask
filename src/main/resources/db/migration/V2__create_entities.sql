INSERT INTO provider (id, name) VALUES (1, "Boggis"), (2, "Bunce"), (3, "Bean");

INSERT INTO product (id, name, type, weight, price)
    VALUES (1, "apples", "antonowka", 1.0, 100.0),
    (2, "apples", "golden", 1.0, 200.0),
    (3, "pear", "chinese", 1.0, 300.0),
    (4, "pear", "duchess", 1.0, 400.0);

INSERT INTO supply (id, provider_id, date_of_supply)
    VALUES (1, 1, "2021-06-21"),
           (2, 1, "2021-05-10"),
           (3, 2, "2021-07-21"),
           (4, 3, "2021-01-30");

INSERT INTO supply_product (supply_id, product_id)
    VALUES (1, 1), (2, 3), (3, 4), (4, 3);