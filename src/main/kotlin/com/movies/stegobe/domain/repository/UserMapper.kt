package com.movies.stegobe.domain.repository

import com.movies.stegobe.domain.entity.Movie
import com.movies.stegobe.domain.entity.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {

    fun selectAll(): List<User>

    fun selectById(id: Int): User

    fun insert(user: User): Int

    fun update(user: User)

    fun delete(id: Int)
}
