CREATE DATABASE testdb DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
GRANT ALL ON testdb.* TO 'testuser'@'localhost' IDENTIFIED BY '1234';
FLUSH PRIVILEGES;