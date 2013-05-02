DROP TABLE IF EXISTS Role;
DROP TABLE IF EXISTS User;

CREATE TABLE User(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  CONSTRAINT username_uniq UNIQUE (username)
);

CREATE TABLE Role(
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  CONSTRAINT role_pk PRIMARY KEY (username, authority),
  CONSTRAINT role_fk FOREIGN KEY (username) REFERENCES User(username)
);

INSERT INTO User(username, password) VALUES ('johnson', 'spring');
INSERT INTO User(username, password) VALUES ('shamim', 'secret');
INSERT INTO User(username, password) VALUES ('gavin', 'hibernate');

INSERT INTO Role(username, authority) VALUES ('johnson', 'ROLE_USER');
INSERT INTO Role(username, authority) VALUES ('johnson', 'ROLE_ADMIN');
INSERT INTO Role(username, authority) VALUES ('shamim', 'ROLE_ADMIN');
INSERT INTO Role(username, authority) VALUES ('gavin', 'ROLE_VISITOR');