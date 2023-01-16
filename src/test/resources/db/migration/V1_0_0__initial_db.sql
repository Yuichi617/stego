# 現状の実装ではこのSQLは実行されません
DROP TABLE IF EXISTS `movies`;
CREATE TABLE movies
(
    id           int          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id      int          NOT NULL,
    name         varchar(255) NOT NULL,
    comment      varchar(255),
    eval         int          NOT NULL,
    genre_id     int          NOT NULL,
    display_flag tinyint(1)   NOT NULL DEFAULT 1,
    created_at   timestamp    NOT NULL DEFAULT current_timestamp,
    updated_at   timestamp    NOT NULL DEFAULT current_timestamp,
    deleted_at   timestamp    NULL DEFAULT NULL
);

DROP TABLE IF EXISTS `users`;
CREATE TABLE users
(
    id         int          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name       varchar(255) NOT NULL,
    password   varchar(255),
    role       int          NOT NULL DEFAULT 0,
    created_at timestamp    NOT NULL DEFAULT current_timestamp,
    updated_at timestamp    NOT NULL DEFAULT current_timestamp,
    deleted_at timestamp    NULL DEFAULT NULL
);

DROP TABLE IF EXISTS `genres`;
CREATE TABLE genres
(
    id         int          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name       varchar(255) NOT NULL,
    created_at timestamp    NOT NULL DEFAULT current_timestamp,
    updated_at timestamp    NOT NULL DEFAULT current_timestamp,
    deleted_at timestamp    NULL DEFAULT NULL
);
