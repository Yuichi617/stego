package com.movies.stegobe.app.internal_v1.form

import javax.validation.constraints.NotNull

data class UserDeleteParam (

    @field:NotNull
    val user_id: Int
    )