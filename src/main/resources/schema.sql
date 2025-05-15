CREATE TABLE IF NOT EXISTS tb_roles (
    id INT PRIMARY KEY,
    authority VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_users (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_users_roles (
    user_id UUID,
    role_id INT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES tb_users(id),
    FOREIGN KEY (role_id) REFERENCES tb_roles(id)
);

CREATE TABLE IF NOT EXISTS tb_movies (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    duration INT NOT NULL,
    description TEXT NOT NULL,
    poster_image VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    movie_cast VARCHAR(255) NOT NULL,
    base_price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_genres (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_movies_genres (
    movie_id INT,
    genre_id INT,
    PRIMARY KEY (movie_id, genre_id),
    FOREIGN KEY (movie_id) REFERENCES tb_movies(id),
    FOREIGN KEY (genre_id) REFERENCES tb_genres(id)
);

CREATE TABLE IF NOT EXISTS tb_theater_rooms (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    capacity INT NOT NULL,
    exhibition_type VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_seats (
    id SERIAL PRIMARY KEY,
    seat_row INT NOT NULL,
    seat_number INT NOT NULL,
    is_special_seat BOOLEAN NOT NULL,
    theater_room_id INT,
    FOREIGN KEY (theater_room_id) REFERENCES tb_theater_rooms(id)
);

CREATE TABLE IF NOT EXISTS tb_sessions (
    id UUID PRIMARY KEY,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    movie_id INT,
    theater_room_id INT,
    FOREIGN KEY (theater_room_id) REFERENCES tb_theater_rooms(id),
    FOREIGN KEY (movie_id) REFERENCES tb_movies(id)
);