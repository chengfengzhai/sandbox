--INSERT INTO USER(id, username, email, password) VALUES(-1, 'Alice','alice@test.com','passwordofalice');
INSERT INTO USER(id, username, email, password) VALUES(-1, 'Alice','alice@test.com','$2a$10$2ZaM5MBOghBWUzM8oLdA/eNPh3U0BR4yH3vDAazST/RuPCO7SGAOe');
INSERT INTO USER(id, username, email, password) VALUES(-2, 'Bob','bob@test.com','$2a$10$jWOYBI2tBmuFdFB.onHKDu3A3347/DBN6wKXM6.fuElxbxrw7WqHK');
INSERT INTO ROLE(id, type) VALUES(1, 'ROLE_USER');
INSERT INTO ROLE(id, type) VALUES(2, 'ROLE_ADMIN');
INSERT INTO USER_ROLE(user_id, role_id) VALUES(-1, 1);
INSERT INTO USER_ROLE(user_id, role_id) VALUES(-1, 2);
INSERT INTO USER_ROLE(user_id, role_id) VALUES(-2, 1);
