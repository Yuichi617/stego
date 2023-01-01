package com.movies.stegobe.domain.service

import com.movies.stegobe.app.internal_v1.form.MovieSearchParam
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

    override fun getById(id: Int): MovieWithRelation =
        movieWithRelationMapper.selectById(id)
}