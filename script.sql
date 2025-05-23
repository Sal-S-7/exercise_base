CREATE DATABASE bank_ex2;
USE bank_ex2;

CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone VARCHAR(20)
);

CREATE TABLE bankaccount (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    total_amount DOUBLE DEFAULT 0,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE operation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amount DOUBLE,
    status ENUM('DEPOSIT', 'WITHDRAWAL'),
    account_id INT,
    FOREIGN KEY (account_id) REFERENCES bankaccount(id)
);

SELECT * FROM customer;
SELECT * FROM operation;
SELECT * FROM bankaccount;

DROP TABLE customer;