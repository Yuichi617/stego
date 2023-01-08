package com.movies.stegobe.domain.entity

import java.time.LocalDateTime

data class Genre(
    val id: Int? = null,
    val name: String?,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
    val deletedAt: LocalDateTime? = null
)