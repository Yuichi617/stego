package com.movies.stegobe.domain.service

import com.movies.stegobe.domain.entity.User

interface UserService {

    /**
     * ユーザ検索
     * @return ユーザ
     */
    fun findAll(): List<User>

    /**
     * IDでユーザ検索
     * @param id ID
     * @return ユーザ
     */
    fun getById(id: Int): User?

    /**
     * ユーザ保存
     * @param user ユーザ
     * @return ユーザ
     */
    fun save(user: User): User

    /**
     * ユーザ削除
     * @param id ID
     * @param userId ユーザID
     */
    fun delete(id: Int, userId: Int)
}
