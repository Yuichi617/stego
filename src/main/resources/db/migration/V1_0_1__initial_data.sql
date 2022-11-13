INSERT INTO movies (user_id, name, comment, eval, genre_id)
VALUES (1, 'アイアンマン1', 'アイアンマン1 コメント', 5, 1),
       (1, 'アイアンマン2', 'アイアンマン2 コメント', 4, 1),
       (2, 'STAR WARS1', 'STAR WARS1 コメント', 5, 2),
       (2, 'STAR WARS2', 'STAR WARS2 コメント', 3, 2);

INSERT INTO users (id, name, password, role)
VALUES (1, 'admin1', 'admin1', 1),
       (2, 'user1', 'user1', 0);

INSERT INTO genres (id, name)
VALUES (1, 'アクション'),
       (2, 'SF');