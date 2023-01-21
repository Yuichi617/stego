package com.movies.stegobe.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class Genre(
    @JsonProperty("id")
    val id: Int? = null,

    @JsonProperty("name")
    val name: String?,

    @JsonProperty("created_at")
    val createdAt: LocalDateTime? = null,

    @JsonProperty("updated_at")
    val updatedAt: LocalDateTime? = null,

    @JsonProperty("deleted_at")
    val deletedAt: LocalDateTime? = null
)