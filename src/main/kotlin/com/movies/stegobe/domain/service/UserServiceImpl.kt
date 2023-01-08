package com.movies.stegobe.domain.service

import com.movies.stegobe.domain.entity.User
import com.movies.stegobe.domain.exception.FkConstraintViolationException
import com.movies.stegobe.domain.exception.ForbiddenException
import com.movies.stegobe.domain.exception.NotFoundException
import com.movies.stegobe.domain.repository.UserMapper
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userMapper: UserMapper
) : UserService {

    override fun findAll(): List<User> = userMapper.selectAll()

    override fun getById(id: Int): User? = userMapper.selectById(id)

    override fun save(user: User): User {
        // 更新か
        val isUpdate = user.id != null

        // 存在チェック
        if (user.id is Int && userMapper.selectById(user.id) == null) {
            throw NotFoundException()
        }

        // 保存
        if (isUpdate) {
            userMapper.update(user)
        } else {
            userMapper.insert(user)
        }

        val savedUser =
            if (user.id is Int) userMapper.selectById(user.id)
            else null

        if (savedUser != null) {
            return savedUser
        } else {
            throw RuntimeException()
        }
    }

    override fun delete(id: Int, userId: Int) {
        // 存在チェック
        if (userMapper.selectById(id) == null) {
            throw NotFoundException()
        }

        // 権限チェック
        val user = userMapper.selectById(userId)
        if (user?.role != 1) {
            throw ForbiddenException("Not authorized to update. user " + user?.name)
        }

        // 論理削除
        userMapper.delete(id)
    }
}