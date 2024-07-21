create database hospitalmanagementsystem;

use hospitalmanagementsystem;

CREATE TABLE login (
    username VARCHAR(150) NOT NULL,
    password VARCHAR(150) NOT NULL,
    PRIMARY KEY (username)
);

INSERT INTO login VALUES('hitesh123','hitesh@123');

DESC login;

SELECT * FROM login;

CREATE TABLE patients (
    aadhar_no VARCHAR(100) PRIMARY KEY,
    P_name VARCHAR(100),
    Age VARCHAR(100),
    Gender VARCHAR(100),
    B_grp VARCHAR(50),
    Address VARCHAR(255),
    P_phn VARCHAR(125),
    Dept VARCHAR(50),
    G_name VARCHAR(100),
    G_phn VARCHAR(150),
    DOR VARCHAR(50)
);

DROP TABLE patients;

DESC patients;