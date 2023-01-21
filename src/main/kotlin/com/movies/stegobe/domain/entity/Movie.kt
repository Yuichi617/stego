package com.movies.stegobe.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

/**
 * 映画投稿
 */
data class Movie (

    @JsonProperty("id")
    val id: Int? = null,

    @JsonProperty("user_id")
    val userId: Int?,

    @JsonProperty("name")
    val name: String?,

    @JsonProperty("comment")
    val comment: String?,

    @JsonProperty("eval")
    val eval: Int?,

    @JsonProperty("genre_id")
    val genreId: Int?,

    @JsonProperty("display_flag")
    val displayFlag: Int? = null,

    @JsonProperty("created_at")
    val createdAt: LocalDateTime? = null,

    @JsonProperty("updated_at")
    val updatedAt: LocalDateTime? = null,

    @JsonProperty("deleted_at")
    val deletedAt: LocalDateTime? = null
)
