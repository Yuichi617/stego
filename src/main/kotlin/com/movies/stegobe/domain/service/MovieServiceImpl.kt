package com.movies.stegobe.domain.service

import com.movies.stegobe.app.internal_v1.form.MovieSearchParam
import com.movies.stegobe.domain.entity.Movie
import com.movies.stegobe.domain.entity.MovieWithRelation
import com.movies.stegobe.domain.exception.NotFoundException
import com.movies.stegobe.domain.repository.MovieWithRelationMapper
import com.movies.stegobe.domain.repository.UserMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MovieServiceImpl(
    private val movieWithRelationMapper: MovieWithRelationMapper,
    private val userMapper: UserMapper
) : MovieService {

    @Transactional(readOnly = true)
    override fun findAllByParam(searchParam: MovieSearchParam): List<MovieWithRelation> {
        return if (searchParam.user_id == null) {
            movieWithRelationMapper.selectAll()
        } else {
            // 存在チェック
            if (userMapper.selectById(searchParam.user_id) == null) {
                throw NotFoundException()
            }
            movieWithRelationMapper.selectBySearchParam(searchParam)
        }
    }

    @Transactional(readOnly = true)
    override fun findById(id: Int): MovieWithRelation =
        movieWithRelationMapper.selectById(id)

    @Transactional
    override fun save(movie: Movie): MovieWithRelation {
        movieWithRelationMapper.insert(movie)
        if (movie.id is Int) {
            return movieWithRelationMapper.selectById(movie.id)
        } else {
            throw RuntimeException()
        }
    }
}