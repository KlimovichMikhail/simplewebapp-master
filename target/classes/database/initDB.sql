DROP TABLE  IF EXISTS employees;  
CREATE TABLE  employees (
  employeeId   BIGINT   PRIMARY KEY,
  firstName    VARCHAR(20)            NOT NULL,
  gender ENUM("MALE", "FEMALE")       NOT NULL,
);