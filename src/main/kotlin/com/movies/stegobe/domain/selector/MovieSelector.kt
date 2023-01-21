package com.movies.stegobe.domain.selector

/**
 * 映画投稿検索セレクタ
 */
data class MovieSelector (
    val userId: Int?,
    val limit: Int,
    val offset: Int,
    val sort: String?
    )
