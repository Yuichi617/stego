package com.movies.stegobe.app.internal_v1.controller

import com.movies.stegobe.domain.entity.Genre
import com.movies.stegobe.domain.service.GenreService
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("internal_api/v1/genres")
class GenreController(
    private val genreService: GenreService
) {

    /**
     * ジャンルGET
     * @return ジャンル
     */
    @GetMapping
    fun get(): List<Genre> = genreService.findAll()

    /**
     * IDでジャンルGET
     * @param id ID
     * @return ジャンル
     */
    @GetMapping("/{id}")
    fun getById(@PathVariable @NotNull id: Int): Genre? = genreService.getById(id)
}