INSERT INTO tb_roles (id, authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO tb_roles (id, authority) VALUES (2, 'ROLE_CLIENT');

INSERT INTO tb_users (id, email, password, name)  VALUES ('5921af5a-b8d5-4013-9ef2-b3948aa592c6', 'maria@email.com', '$2a$12$ZDot9DIch7wMDd/7rCCmXOmKEDmWLt4RpHNAjJFD211xZqdql3Z8S', 'Maria');
INSERT INTO tb_users_roles (user_id, role_id) VALUES ('5921af5a-b8d5-4013-9ef2-b3948aa592c6', 1);

INSERT INTO tb_movies (id, title, duration, description, poster_image, director, movie_cast, base_price) VALUES
(1, 'Interestelar', 169, 'Após ver a Terra consumindo boa parte de suas reservas naturais, um grupo de astronautas recebe a missão de verificar possíveis planetas para receberem a população mundial, possibilitando a continuação da espécie. Cooper (Matthew McConaughey) é chamado para liderar o grupo e aceita a missão sabendo que pode nunca mais ver os filhos. Ao lado de Brand (Anne Hathaway), Jenkins (Marlon Sanders) e Doyle (Wes Bentley), ele seguirá em busca de uma nova casa. Com o passar dos anos, sua filha Murph (Mackenzie Foy e Jessica Chastain) investirá numa própria jornada para também tentar salvar a população do planeta.', 'https://pt.wikipedia.org/wiki/Interstellar#/media/Ficheiro:Interstellar_Filme.png', 'Christopher Nolan', 'Matthew McConaughey, Anne Hathaway', 40.00); 

INSERT INTO tb_genres (id, name) VALUES (1, 'Ficção Científica');
INSERT INTO tb_movies_genres (movie_id, genre_id) VALUES (1, 1);