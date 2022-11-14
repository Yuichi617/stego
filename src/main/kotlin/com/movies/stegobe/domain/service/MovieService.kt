package com.movies.stegobe.domain.service

import com.movies.stegobe.domain.entity.MovieWithRelation

interface MovieService {

    /** 全映画投稿取得 */
    fun findByUserId(userId : Int?): List<MovieWithRelation>

    /** IDで映画投稿取得 */
    fun getById(id: Int): MovieWithRelation
}
