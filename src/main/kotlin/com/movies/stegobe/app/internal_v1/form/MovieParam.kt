package com.movies.stegobe.app.internal_v1.form

import org.hibernate.validator.constraints.Range
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import javax.validation.groups.Default

/**
 * 映画投稿パラメータ
 */
data class MovieParam (

        /** ユーザID */
        @field:NotNull(groups = [Post::class, Put::class])
        val user_id: Int?,

        /** タイトル */
        @field:NotBlank(groups = [Post::class, Put::class])
        @field:Size(max = 255, groups = [Post::class, Put::class])
        val name: String?,

        /** コメント */
        @field:Size(max = 255, groups = [Post::class, Put::class])
        val comment: String?,

        /** 評価 */
        @field:NotNull(groups = [Post::class, Put::class])
        @field:Range(min = 1, max = 5, groups = [Post::class, Put::class])
        val eval: Int?,

        /** ジャンルID */
        @field:NotNull(groups = [Post::class, Put::class])
        val genre_id: Int?
) {
        //** POSTの場合のみ有効（バリデーショングループ用インターフェース） */
        interface Post : Default
        //** PUTの場合のみ有効（バリデーショングループ用インターフェース） */
        interface Put : Default
}
