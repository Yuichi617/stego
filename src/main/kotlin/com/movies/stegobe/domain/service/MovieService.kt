package com.movies.stegobe.domain.service

import com.movies.stegobe.app.internal_v1.form.MovieSearchParam
import com.movies.stegobe.domain.entity.MovieWithRelation

interface MovieService {

    /**
     * 映画投稿検索
     * @param searchParam 検索パラメータ
     * @return 映画投稿
     */
    fun findAllByParam(searchParam: MovieSearchParam): List<MovieWithRelation>

    /**
     * IDで映画投稿検索
     * @return 映画投稿
     */
    fun getById(id: Int): MovieWithRelation
}
