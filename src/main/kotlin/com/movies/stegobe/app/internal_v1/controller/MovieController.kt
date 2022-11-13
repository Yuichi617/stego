package com.movies.stegobe.app.internal_v1.controller

import com.movies.stegobe.domain.entity.Movie
import com.movies.stegobe.domain.service.MovieService
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("internal_api/v1/movies")
class MovieController(
    private val movieService: MovieService
) {

    /**
     *  ユーザIDで映画投稿取得
     *  user_idが指定されなかった場合、全映画投稿取得
     */
    @GetMapping
    fun getByUserId(
        @RequestParam(value = "user_id", required = false) userId: Int?
    ): List<Movie> {
        return movieService.findByUserId(userId)
    }

    /** IDで映画投稿取得 */
    @GetMapping("/{id}")
    fun getById(@PathVariable @NotNull id: Int): Movie {
        return movieService.getById(id)
    }
}
