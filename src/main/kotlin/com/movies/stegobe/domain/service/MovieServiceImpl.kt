package com.movies.stegobe.domain.service

import com.movies.stegobe.domain.entity.MovieWithRelation
import com.movies.stegobe.domain.exception.NotFoundException
import com.movies.stegobe.domain.repository.MovieWithRelationMapper
import com.movies.stegobe.domain.repository.UserMapper
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl(
    private val movieWithRelationMapper: MovieWithRelationMapper,
    private val userMapper: UserMapper
) : MovieService {

    override fun findByUserId(userId: Int?): List<MovieWithRelation> {
        return if (userId == null) {
            movieWithRelationMapper.selectAll()
        } else {
            // 存在チェック
            if (userMapper.selectById(userId) == null) {
                throw NotFoundException()
            }
            movieWithRelationMapper.selectByUserId(userId)
        }
    }

    override fun getById(id: Int): MovieWithRelation {
        return movieWithRelationMapper.selectById(id)
    }
}