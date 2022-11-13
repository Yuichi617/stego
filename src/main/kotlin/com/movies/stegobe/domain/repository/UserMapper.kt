package com.movies.stegobe.domain.repository

import com.movies.stegobe.domain.entity.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {

    fun selectAll(): List<User>

    fun selectById(id: Int): User
}
