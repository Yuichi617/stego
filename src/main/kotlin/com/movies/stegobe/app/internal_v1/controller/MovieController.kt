package com.movies.stegobe.app.internal_v1.controller

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
     *  ユーザIDで映画投稿取得
     *  user_idが指定されなかった場合、全映画投稿取得
     */
    @GetMapping
    fun getByUserId(
        @RequestParam(value = "user_id", required = false) userId: Int?
    ): List<MovieWithRelation> {
        return movieService.findByUserId(userId)
    }

    /** IDで映画投稿取得 */
    @GetMapping("/{id}")
    fun getById(@PathVariable @NotNull id: Int): MovieWithRelation {
        return movieService.getById(id)
    }
}
