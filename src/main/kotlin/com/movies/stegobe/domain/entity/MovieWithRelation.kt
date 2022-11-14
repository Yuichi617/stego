package com.movies.stegobe.domain.entity

import java.time.LocalDateTime

data class MovieWithRelation(
    val id: Int,
    val userId: Int,
    val name: String,
    val comment: String? = null,
    val eval: Int,
    val genreId: Int,
    val displayFlag: Int,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
    val deletedAt: LocalDateTime? = null,
    val genreName: String
)