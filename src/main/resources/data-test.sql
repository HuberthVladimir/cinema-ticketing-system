INSERT INTO tb_roles (id, authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO tb_roles (id, authority) VALUES (2, 'ROLE_CLIENT');

INSERT INTO tb_users (id, email, password, name)  VALUES ('5921af5a-b8d5-4013-9ef2-b3948aa592c6', 'maria@email.com', '$2a$12$ZDot9DIch7wMDd/7rCCmXOmKEDmWLt4RpHNAjJFD211xZqdql3Z8S', 'Maria');
INSERT INTO tb_users_roles (user_id, role_id) VALUES ('5921af5a-b8d5-4013-9ef2-b3948aa592c6', 1);