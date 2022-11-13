package com.movies.stegobe.domain.service

import com.movies.stegobe.domain.entity.User

interface UserService {

    /** 全ユーザ取得 */
    fun get(): List<User>

    /** IDでユーザ取得 */
    fun getById(id: Int): User
}
