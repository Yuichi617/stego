package com.movies.stegobe.app.internal_v1.controller

import com.movies.stegobe.app.internal_v1.form.MovieParam
import com.movies.stegobe.app.internal_v1.form.MovieSearchParam
import com.movies.stegobe.domain.entity.Movie
import com.movies.stegobe.domain.entity.MovieWithRelation
import com.movies.stegobe.domain.service.MovieService
import org.jetbrains.annotations.NotNull
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("internal_api/v1/movies")
class MovieController(
    private val movieService: MovieService
) {

    /**
     * 映画投稿GET
     * @param searchParam 検索パラメータ
     * @return 関連情報付き映画投稿
     */
    @GetMapping
    fun get(@ModelAttribute searchParam: MovieSearchParam): List<MovieWithRelation> =
        movieService.findAllByParam(searchParam)

    /**
     * IDで映画投稿GET
     * @param id ID
     * @return 関連情報付き映画投稿
     */
    @GetMapping("/{id}")
    fun getById(@PathVariable @NotNull id: Int): MovieWithRelation? =
        movieService.getById(id)

    /**
     * 映画投稿POST
     * @param postParam 映画投稿POSTパラメータ
     * @return 関連情報付き映画投稿
     */
    @PostMapping
    fun post(@RequestBody @Validated(MovieParam.Post::class) postParam: MovieParam): MovieWithRelation =
            movieService.save(Movie(
                userId = postParam.user_id,
                name = postParam.name,
                comment = postParam.comment,
                eval = postParam.eval,
                genreId = postParam.genre_id
            ))

    /**
     * 映画投稿PUT
     * @param id ID
     * @param putParam 映画投稿PUTパラメータ
     * @return 関連情報付き映画投稿
     */
    @PutMapping("/{id}")
    fun put(
        @PathVariable id: Int,
        @RequestBody @Validated(MovieParam.Put::class) putParam: MovieParam
    ): MovieWithRelation =
        movieService.save(Movie(
            id = id,
            userId = putParam.user_id,
            name = putParam.name,
            comment = putParam.comment,
            eval = putParam.eval,
            genreId = putParam.genre_id
        ))

    /**
     * 映画投稿DELETE
     * @param id ID
     */
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) =
        movieService.delete(id)
}
