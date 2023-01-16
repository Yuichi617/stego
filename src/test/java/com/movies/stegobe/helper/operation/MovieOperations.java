package com.movies.stegobe.helper.operation;

import com.movies.stegobe.domain.entity.Genre;
import com.movies.stegobe.domain.entity.Movie;
import com.movies.stegobe.domain.entity.User;
import com.ninja_squad.dbsetup.operation.Operation;

import java.util.List;

import static com.movies.stegobe.helper.operation.OperationUtils.*;

public class MovieOperations extends CommonOperations {

    /** moviesテーブルのINSERT対象カラム名 */
    public static final String[] GROUP_COLUMN =
            {"id", "user_id", "name", "comment", "eval", "genre_id", "display_flag", "created_at", "updated_at", "deleted_at"};

    /** moviesテーブルのデータセット */
    public static final List<Movie> DATA_SET_MOVIE = List.of(
            // id, userId, eval, genreId, displayFlag, createdAt, updatedAt
            movie(1, 1, 1, 1, 1, CT.minusDays(1L), CT.plusDays(5L)),
            movie(2, 1, 2, 1, 1, CT.minusDays(2L), CT.plusDays(4L)),
            movie(3, 1, 3, 2, 1, CT.minusDays(3L), CT.plusDays(3L)),
            movie(4, 2, 4, 2, 1, CT.minusDays(4L), CT.plusDays(2L)),
            movie(5, 2, 5, 2, 1, CT.minusDays(5L), CT.plusDays(1L))
    );

    /** moviesテーブルのINSERT */
    public static final Operation INSERT_MOVIE = buildInsert("movies", DATA_SET_MOVIE, GROUP_COLUMN);

    /** usersテーブルのINSERT対象カラム名 */
    public static final String[] USER_COLUMN =
            {"id", "name", "password", "role", "created_at", "updated_at", "deleted_at"};

    /** usersテーブルのデータセット */
    public static final List<User> DATA_SET_USER = List.of(
            // id, role, createdAt, updatedAt
            user(1, 0, CT.minusDays(1L), CT.plusDays(2L)),
            user(2, 0, CT.minusDays(2L), CT.plusDays(1L))
    );

    /** usersテーブルのINSERT */
    public static final Operation INSERT_USER = buildInsert("users", DATA_SET_USER, USER_COLUMN);

    /** genresテーブルのINSERT対象カラム名 */
    public static final String[] GENRE_COLUMN =
            {"id", "name", "created_at", "updated_at", "deleted_at"};

    /** genresテーブルのデータセット */
    public static final List<Genre> DATA_SET_GENRE = List.of(
            // id, createdAt, updatedAt
            genre(1,  CT.minusDays(1L), CT.plusDays(2L)),
            genre(2,  CT.minusDays(2L), CT.plusDays(1L))
    );

    /** genresテーブルのINSERT */
    public static final Operation INSERT_GENRE = buildInsert("genres", DATA_SET_GENRE, GENRE_COLUMN);
}
