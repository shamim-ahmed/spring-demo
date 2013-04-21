DROP TABLE IF EXISTS Message;
DROP TABLE IF EXISTS User;

CREATE TABLE User(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  join_date DATE NOT NULL,
  receive_email BOOLEAN NOT NULL DEFAULT 0
);

CREATE TABLE Message(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  content VARCHAR(200) NOT NULL,
  created_on DATE NOT NULL,
  user_id INTEGER NOT NULL,
  CONSTRAINT message_fk FOREIGN KEY (user_id) REFERENCES User(id)
);

INSERT INTO User(id, username, password, join_date, receive_email) VALUES (1, 'johnson', 'spring', '2013-04-21', true);
INSERT INTO User(id, username, password, join_date, receive_email) VALUES (2, 'gavin', 'hibernate', '2013-04-21', false);
INSERT INTO Message(id, content, created_on, user_id) VALUES (1, 'Spring rocks !', '2013-04-21', 1);
INSERT INTO Message(id, content, created_on, user_id) VALUES (2, 'Hibernate rocks !', '2013-04-21', 2);