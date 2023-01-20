package com.movies.stegobe.domain.service

import com.movies.stegobe.domain.entity.Movie
import com.movies.stegobe.domain.entity.MovieWithRelation
import com.movies.stegobe.domain.selector.MovieSelector

interface MovieService {

    /**
     * 関連情報付き映画投稿検索
     * @param selector セレクタ
     * @return 関連情報付き映画投稿
     */
    fun findAllByParam(selector: MovieSelector): List<MovieWithRelation>

    /**
     * IDで関連情報付き映画投稿検索
     * @return 関連情報付き映画投稿
     */
    fun getById(id: Int): MovieWithRelation?

    /**
     * 映画投稿保存
     * @param movie 映画投稿
     * @return 関連情報付き映画投稿
     */
    fun save(movie: Movie): MovieWithRelation

    /**
     * 映画投稿削除
     * @param id ID
     */
    fun delete(id: Int)
}
