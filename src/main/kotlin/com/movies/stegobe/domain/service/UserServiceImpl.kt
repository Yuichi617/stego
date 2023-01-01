package com.movies.stegobe.domain.service

import com.movies.stegobe.domain.entity.User
import com.movies.stegobe.domain.repository.UserMapper
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userMapper: UserMapper
) : UserService {

    override fun find(): List<User> = userMapper.selectAll()

    override fun findById(id: Int): User = userMapper.selectById(id)
}