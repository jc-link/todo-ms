CREATE DATABASE todoDB;
USE todoDB;
CREATE TABLE task (
  id int auto_increment,
  name varchar(50),
  description varchar(100),
  completed boolean,
  primary key(id)
);
