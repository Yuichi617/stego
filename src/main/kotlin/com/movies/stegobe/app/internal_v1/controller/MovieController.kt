package com.movies.stegobe.app.internal_v1.controller

import com.movies.stegobe.app.internal_v1.form.MovieSearchParam
import com.movies.stegobe.domain.entity.MovieWithRelation
import com.movies.stegobe.domain.service.MovieService
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("internal_api/v1/movies")
class MovieController(
    private val movieService: MovieService
) {

    /**
     * 映画投稿GET
     * @param searchParam 検索パラメータ
     * @return 映画投稿
     */
    @GetMapping
    fun get(@ModelAttribute searchParam: MovieSearchParam): List<MovieWithRelation>
        = movieService.findAllByParam(searchParam)

    /**
     * IDで映画投稿GET
     * @param id ID
     * @return 映画投稿
     */
    @GetMapping("/{id}")
    fun getById(@PathVariable @NotNull id: Int): MovieWithRelation =
        movieService.getById(id)
}
