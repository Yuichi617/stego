package com.movies.stegobe.domain.service

import com.movies.stegobe.domain.entity.Genre
import com.movies.stegobe.domain.repository.GenreMapper
import org.springframework.stereotype.Service

@Service
class GenreServiceImpl(
    private val genreMapper: GenreMapper
) : GenreService {
    override fun findAll(): List<Genre> = genreMapper.selectAll()

    override fun getById(id: Int): Genre? = genreMapper.selectById(id)
}