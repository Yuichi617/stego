package com.movies.stegobe.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

/**
 * 映画投稿関連情報
 */
data class MovieWithRelation(
    @JsonProperty("id") val id: Int,
    @JsonProperty("user_id") val userId: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("comment") val comment: String? = null,
    @JsonProperty("eval") val eval: Int,
    @JsonProperty("genre_id") val genreId: Int,
    @JsonProperty("display_flag") val displayFlag: Int,
    @JsonProperty("created_at") val createdAt: LocalDateTime? = null,
    @JsonProperty("updated_at") val updatedAt: LocalDateTime? = null,
    @JsonProperty("deleted_at") val deletedAt: LocalDateTime? = null,
    @JsonProperty("genre_name") val genreName: String
)