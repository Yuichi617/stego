package com.movies.stegobe.domain.service

import com.movies.stegobe.domain.entity.User

interface UserService {

    /**
     * ユーザ検索
     * @return ユーザ
     */
    fun find(): List<User>

    /**
     * IDでユーザ検索
     * @param ID
     * @return ユーザ
     */
    fun findById(id: Int): User
}
