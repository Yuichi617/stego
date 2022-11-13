package com.movies.stegobe.domain.service

import com.movies.stegobe.domain.entity.Movie

interface MovieService {

    /** 全映画投稿取得 */
    fun findByUserId(userId : Int?): List<Movie>

    /** IDで映画投稿取得 */
    fun getById(id: Int): Movie
}
