package com.movies.stegobe.domain.service

import com.movies.stegobe.domain.entity.User
import com.movies.stegobe.domain.repository.UserMapper
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userMapper: UserMapper
) : UserService {

    override fun get(): List<User> {
        return userMapper.selectAll()
    }

    override fun getById(id: Int): User {
        return userMapper.selectById(id)
    }
}