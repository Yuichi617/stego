package com.movies.stegobe.domain.entity

import java.time.LocalDateTime

/**
 * ユーザ
 */
data class User(
    val id: Int? = null,
    val name: String?,
    val password: String?,
    val role: Int? = null,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
    val deletedAt: LocalDateTime? = null
)
