package com.movies.stegobe.domain.service

import com.movies.stegobe.domain.entity.Movie
import com.movies.stegobe.domain.exception.NotFoundException
import com.movies.stegobe.domain.repository.MovieMapper
import com.movies.stegobe.domain.repository.UserMapper
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl(
    private val movieMapper: MovieMapper,
    private val userMapper: UserMapper
) : MovieService {

    override fun findByUserId(userId: Int?): List<Movie> {
        return if (userId == null) {
            movieMapper.selectAll()
        } else {
            // 存在チェック
            if (userMapper.selectById(userId) == null) {
                throw NotFoundException()
            }
            movieMapper.selectByUserId(userId)
        }
    }

    override fun getById(id: Int): Movie {
        return movieMapper.selectById(id)
    }
}