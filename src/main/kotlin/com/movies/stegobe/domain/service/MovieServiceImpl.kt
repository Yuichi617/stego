package com.movies.stegobe.domain.service

import com.movies.stegobe.app.internal_v1.form.MovieSearchParam
import com.movies.stegobe.domain.entity.Movie
import com.movies.stegobe.domain.entity.MovieWithRelation
import com.movies.stegobe.domain.exception.FkConstraintViolationException
import com.movies.stegobe.domain.exception.NotFoundException
import com.movies.stegobe.domain.repository.MovieMapper
import com.movies.stegobe.domain.repository.MovieWithRelationMapper
import com.movies.stegobe.domain.repository.UserMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MovieServiceImpl(
    private val movieWithRelationMapper: MovieWithRelationMapper,
    private val movieMapper: MovieMapper,
    private val userMapper: UserMapper
) : MovieService {

    @Transactional(readOnly = true)
    override fun findAllByParam(searchParam: MovieSearchParam): List<MovieWithRelation> =
        movieWithRelationMapper.selectBySearchParam(searchParam)

    @Transactional(readOnly = true)
    override fun getById(id: Int): MovieWithRelation? =
        movieWithRelationMapper.selectById(id)

    @Transactional
    override fun save(movie: Movie): MovieWithRelation {
        // 更新か
        val isUpdate = movie.id != null

        // TODO: ジャンルの外部キー制約チェック実装
        // 外部キー制約チェック
        // ユーザ
        if (movie.userId is Int && userMapper.selectById(movie.userId) == null) {
            throw FkConstraintViolationException(Movie::class, "userId", movie.userId)
        }

        // 存在チェック
        if (movie.id is Int && movieWithRelationMapper.selectById(movie.id) == null) {
            throw NotFoundException()
        }

        // 保存
        if (isUpdate) {
            movieMapper.update(movie)
        } else {
            movieMapper.insert(movie)
        }

        val savedMovie =
            if (movie.id is Int) movieWithRelationMapper.selectById(movie.id)
            else null

        if (savedMovie != null) {
            return savedMovie
        } else {
            throw RuntimeException()
        }
    }

    @Transactional
    override fun delete(id: Int) {
        // 存在チェック
        if (movieWithRelationMapper.selectById(id) == null) {
            throw NotFoundException()
        }
        // 論理削除
        movieMapper.delete(id)
    }
}
