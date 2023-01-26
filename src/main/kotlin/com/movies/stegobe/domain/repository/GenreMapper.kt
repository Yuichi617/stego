package com.movies.stegobe.domain.repository

import com.movies.stegobe.domain.entity.Genre
import org.apache.ibatis.annotations.Mapper

@Mapper
interface GenreMapper {

    fun selectAll(): List<Genre>

    fun selectById(id: Int): Genre
}