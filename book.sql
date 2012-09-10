DROP TABLE IF EXISTS books;
CREATE TABLE books
(
  book_id         BIGINT  PRIMARY KEY AUTO_INCREMENT,
  title           VARCHAR(255),
  authours        VARCHAR(255),
  edition         VARCHAR(60),
  isbn10          VARCHAR(20) UNIQUE,
  isbn13          VARCHAR(40) UNIQUE,
  publisher       VARCHAR(255),
  publishing_date DATE
) ENGINE=InnoDB;

INSERT INTO books (`title`, `authours`, `edition`, `isbn10`, `isbn13`, `publisher`, `publishing_date`) VALUES ('Effective Java', 'Joshua Bloch', '2nd Edition', '0321356683', '978-0321356680', 'Prentice Hall', '2008-05-28')
, ('The Mythical Man-Month: Essays on Software Engineering', 'Frederick P. Brooks', 'Anniversary Edition (2nd Edition)', '0201835959', '978-0201835953', 'Addison-Wesley Professional', '1995-08-12')
, ('Expert One-on-One J2EE Development without EJB', 'Rod Johnson, Juergen Hoeller', '', '0764558315', '978-0764558313', 'Wrox', '2004-06-21');
COMMIT;