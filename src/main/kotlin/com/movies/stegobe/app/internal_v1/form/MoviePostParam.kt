package com.movies.stegobe.app.internal_v1.form

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class MoviePostParam (

        /** ユーザID */
        @field:NotNull
        val user_id: Int?,

        /** タイトル */
        @field:NotBlank
        val name: String?,

        /** コメント */
        val comment: String?,

        /** 評価 */
        @field:NotNull
        val eval: Int?,

        /** ジャンルID */
        @field:NotNull
        val genre_id: Int?
)