package com.movies.stegobe.app.internal_v1.form

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

/**
 * ユーザパラメータ
 */
data class UserParam (

        /** 名前 */
        @field:NotBlank
        @field:Size(max = 255)
        val name: String?,

        /** パスワード */
        val password: String? = null
)