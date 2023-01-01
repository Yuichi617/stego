package com.movies.stegobe.domain.service

import com.movies.stegobe.app.internal_v1.form.MoviePostParam
import com.movies.stegobe.app.internal_v1.form.MovieSearchParam
import com.movies.stegobe.domain.entity.Movie
import com.movies.stegobe.domain.entity.MovieWithRelation

interface MovieService {

    /**
     * 関連情報付き映画投稿検索
     * @param searchParam 検索パラメータ
     * @return 関連情報付き映画投稿
     */
    fun findAllByParam(searchParam: MovieSearchParam): List<MovieWithRelation>

    /**
     * IDで関連情報付き映画投稿検索
     * @return 関連情報付き映画投稿
     */
    fun findById(id: Int): MovieWithRelation

    /**
     * 映画投稿保存
     * @param movie 映画投稿
     * @return 関連情報付き映画投稿
     */
    fun save(movie: Movie): MovieWithRelation
}
