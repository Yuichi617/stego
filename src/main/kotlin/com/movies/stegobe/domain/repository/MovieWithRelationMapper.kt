package com.movies.stegobe.domain.repository

import com.movies.stegobe.domain.entity.MovieWithRelation
import org.apache.ibatis.annotations.Mapper

@Mapper
interface MovieWithRelationMapper {

    fun selectAll(): List<MovieWithRelation>

    fun selectById(id: Int): MovieWithRelation

    fun selectByUserId(userId: Int): List<MovieWithRelation>
}