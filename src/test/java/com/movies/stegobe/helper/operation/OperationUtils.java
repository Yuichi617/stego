package com.movies.stegobe.helper.operation;

import com.movies.stegobe.domain.entity.Genre;
import com.movies.stegobe.domain.entity.Movie;
import com.movies.stegobe.domain.entity.User;

import java.time.LocalDateTime;

/**
 * オペレーションユーティリティ
 */
public class OperationUtils {

    /**
     * Movieインスタンス作成
     *
     * @param id ID
     * @param userId ユーザID
     * @param eval 評価
     * @param genreId ジャンルID
     * @param displayFlag 表示フラグ
     * @param createdAt 作成日時
     * @param updatedAt 更新日時
     * @return 映画投稿
     */
    public static Movie movie(
            Integer id,
            Integer userId,
            Integer eval,
            Integer genreId,
            Integer displayFlag,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        return new Movie(
                id, userId, "movie_" + id, "comment_" + id, eval, genreId, displayFlag,
                createdAt, updatedAt, null
        );
    }

    /**
     * Userインスタンス作成
     *
     * @param id ID
     * @param role ロール
     * @param createdAt 作成日時
     * @param updatedAt 更新日時
     * @return ユーザ
     */
    public static User user(
            Integer id,
            Integer role,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        return new User(
                id, "user_" + id, "password_" + id, role,
                createdAt, updatedAt, null
        );
    }

    /**
     * Genreインスタンス作成
     *
     * @param id Id
     * @param createdAt 作成日時
     * @param updatedAt 更新日時
     * @return ジャンル
     */
    public static Genre genre(
            Integer id,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        return new Genre(
                id, "genre_" + 1, createdAt, updatedAt, null
        );
    }
}
