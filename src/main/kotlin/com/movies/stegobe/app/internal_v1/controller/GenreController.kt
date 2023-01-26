package com.movies.stegobe.app.internal_v1.controller

import com.movies.stegobe.domain.entity.Genre
import com.movies.stegobe.domain.service.GenreService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
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
    @ApiOperation(value = "ジャンルを取得する", notes = "")
    fun get(): List<Genre> = genreService.findAll()

    /**
     * IDでジャンルGET
     * @param id ID
     * @return ジャンル
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "IDでジャンルを取得する", notes = "")
    fun getById(@ApiParam(value = "ジャンルID", example = "123") @PathVariable @NotNull id: Int): Genre? = genreService.getById(id)
}