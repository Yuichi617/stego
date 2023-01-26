package com.movies.stegobe.domain.service

import com.movies.stegobe.domain.entity.Genre

interface GenreService {

    /**
     * ジャンル検索
     * @return ジャンル
     */
    fun findAll(): List<Genre>

    /**
     * IDでジャンル検索
     * @param id ID
     * @return ジャンル
     */
    fun getById(id: Int): Genre?
}