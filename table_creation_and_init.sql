DROP TABLE IF EXISTS people;
CREATE TABLE people
(
  person_id   BIGINT  PRIMARY KEY AUTO_INCREMENT,
  surname     VARCHAR(20),
  given_name  VARCHAR(20),
  street      VARCHAR(50),
  city        VARCHAR(50),
  state       VARCHAR(50),
  country     VARCHAR(50),
  postcode    VARCHAR(50),
  birthday    DATE
) ENGINE=InnoDB;

INSERT INTO people (surname, given_name, street, city, state, country, postcode, birthday) VALUES
('Kent', 'Clark', '123 ABC Street', 'Sydney', 'NSW', 'Australia', '2000', '1938-04-18'),
('Wayne', 'Bruce', '111 XYZ Street', 'Sydney', 'NSW', 'Australia', '2000', '1939-05-01'), 
('Parker', 'Peter', '333 AAA Street', 'Melbourne', 'Victoria', 'Australia', '3000', '1962-08-01'),
('Jordan', 'Hal', '555 BBB Street', 'Melbourne', 'Victoria', 'Australia', '3000', '1959-10-02');
COMMIT;
SELECT * FROM people;