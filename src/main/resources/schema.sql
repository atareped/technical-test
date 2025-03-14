CREATE TABLE prices(
  id INT NOT NULL,
  brand_id INT,
  start_date DATETIME,
  end_date DATETIME,
  price_list INT,
  product_id INT,
  priority INT,
  price FLOAT,
  curr VARCHAR(20),
  PRIMARY KEY (id)
);

INSERT INTO prices (id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES
    (1, 1, '2020-06-14 00.00.00', '2020-12-31 23.59.59', 1, 35455, 0, 35.50, 'EUR'),
    (2, 1, '2020-06-14 15.00.00', '2020-06-14 18.30.00', 2, 35455, 1, 25.45, 'EUR'),
    (3, 1, '2020-06-15 00.00.00', '2020-06-15 11.00.00', 3, 35455, 1, 30.50, 'EUR'),
    (4, 1, '2020-06-15 16.00.00', '2020-12-31 23.59.59', 4, 35455, 1, 38.95, 'EUR');