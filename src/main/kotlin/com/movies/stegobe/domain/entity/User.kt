package com.movies.stegobe.domain.entity

import java.time.LocalDateTime

/**
 * ユーザ
 */
data class User(
    val id: Int,
    val name: String,
    val password: String? = null,
    val role: Int,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
    val deletedAt: LocalDateTime? = null
)
