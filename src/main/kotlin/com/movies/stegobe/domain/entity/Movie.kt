package com.movies.stegobe.domain.entity

import java.time.LocalDateTime

/**
 * 映画投稿
 */
data class Movie (
    val id: Int? = null,
    val userId: Int?,
    val name: String?,
    val comment: String? = null,
    val eval: Int?,
    val genreId: Int?,
    val displayFlag: Int? = null,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
    val deletedAt: LocalDateTime? = null
)
