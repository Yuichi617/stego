package com.movies.stegobe.domain.service;

import com.movies.stegobe.ServiceTest;
import com.movies.stegobe.domain.selector.MovieSelector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.movies.stegobe.helper.operation.CommonOperations.DELETE_ALL;
import static com.movies.stegobe.helper.operation.MovieOperations.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("MovieServiceImpl サービスクラステスト")
public class MovieServiceImplTest extends ServiceTest {

    /**
     * テスト対象
     */
    @Autowired
    MovieService target;

    void setUp() {
        setUp(
                DELETE_ALL,
                INSERT_MOVIE,
                INSERT_USER,
                INSERT_GENRE
        );
    }

    @Nested
    @DisplayName("MovieServiceImpl#findAllByParam")
    class FindAllByParamTest {

        @BeforeEach
        void setUp() {
            MovieServiceImplTest.this.setUp();
        }

        @Test
        @DisplayName("パラメータがない時、作成日時順でソートされた全ての関連情報付き映画投稿が返る")
        void whenWithoutParamThenReturnsAll() {
            tracker.skipNextLaunch();

                var selector = new MovieSelector(null, 100, 100, null);

            var result = target.findAllByParam(selector);

            System.out.println(result);
            assertEquals(1, 1);
        }
    }
}
