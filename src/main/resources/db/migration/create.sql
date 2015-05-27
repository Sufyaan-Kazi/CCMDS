DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS statements;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS contacts;
DROP TABLE IF EXISTS agents;

CREATE TABLE agents (
  id tinyint(3) NOT NULL AUTO_INCREMENT,
  first_name varchar(50) DEFAULT NULL,
  last_name varchar(50) DEFAULT NULL,
  email varchar(30) DEFAULT NULL,
  phone varchar(20) DEFAULT NULL,
  address1 varchar(50) DEFAULT NULL,
  address2 varchar(50) DEFAULT NULL,
  address3 varchar(50) DEFAULT NULL,
  address4 varchar(50) DEFAULT NULL,
  address5 varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE contacts (
  id mediumint(6) NOT NULL AUTO_INCREMENT,
  agent_id tinyint(3) DEFAULT NULL,
  first_name varchar(50) DEFAULT NULL,
  last_name varchar(50) DEFAULT NULL,
  email varchar(30) DEFAULT NULL,
  phone varchar(20) DEFAULT NULL,
  address1 varchar(100) DEFAULT NULL,
  address2 varchar(100) DEFAULT NULL,
  address3 varchar(100) DEFAULT NULL,
  address4 varchar(100) DEFAULT NULL,
  address5 varchar(100) DEFAULT NULL,
  extaccno varchar(32) DEFAULT NULL,
  profession varchar(50) DEFAULT NULL,
  age tinyint(3) DEFAULT NULL,
  income mediumint(10) DEFAULT NULL,
  marital_status varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `contacts_fk1` FOREIGN KEY (`agent_id`) REFERENCES `agents` (`id`)
);

CREATE TABLE customers (
  id mediumint(6) NOT NULL AUTO_INCREMENT,
  currentbalance int DEFAULT NULL,
  account_count tinyint(1) DEFAULT NULL,
  statement_count smallint(5) DEFAULT NULL,
  txn_count int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE accounts (
  id mediumint(6) NOT NULL AUTO_INCREMENT,
  customer_id mediumint(6) DEFAULT NULL,
  contact_id mediumint(6) DEFAULT NULL,
  start_date date DEFAULT NULL,
  acctype varchar(20) DEFAULT NULL,
  segmentation varchar(20) DEFAULT NULL,
  acc_limit int DEFAULT NULL,
  current_balance decimal(15,2) default null,
  income_received decimal(15,2) default null,
  statement_count mediumint default null,
  bal_segment varchar(25) default null,
  txn_count integer default null,
  PRIMARY KEY (`id`),
  CONSTRAINT `accounts_fk1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `accounts_fk2` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`id`)
);

CREATE TABLE statements (
  acc_id mediumint(6) NOT NULL,
  statement_id mediumint(6) NOT NULL,
  year smallint(4) DEFAULT NULL,
  month tinyint(2) DEFAULT NULL,
  opening_balance decimal(10,2) default null,
  closing_balance decimal(10,2) default null,
  min_payment decimal(10,2) default null,
  txn_count mediumint default null,
  PRIMARY KEY (acc_id,statement_id),
  CONSTRAINT `statements_fk1` FOREIGN KEY (`acc_id`) REFERENCES `accounts` (`id`)
);

CREATE TABLE transactions (
  acc_id mediumint(6) NOT NULL,
  statement_id mediumint(6) NOT NULL,
  tx_id mediumint(6) NOT NULL,
  tx_date date DEFAULT NULL,
  amount decimal(10,2) default null,  
  description varchar(200) DEFAULT NULL,
  category varchar(30) DEFAULT NULL,
  PRIMARY KEY (acc_id,statement_id, tx_id),
  CONSTRAINT `transactions_fk1` FOREIGN KEY (`acc_id`, `statement_id`) REFERENCES `statements` (`acc_id`, `statement_id`)
);
