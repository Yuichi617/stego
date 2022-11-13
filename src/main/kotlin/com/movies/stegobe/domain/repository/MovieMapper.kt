package com.movies.stegobe.domain.repository

import com.movies.stegobe.domain.entity.Movie
import org.apache.ibatis.annotations.Mapper

@Mapper
interface MovieMapper {

    fun selectAll(): List<Movie>

    fun selectById(id: Int): Movie

    fun selectByUserId(userId: Int): List<Movie>
}