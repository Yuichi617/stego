package com.movies.stegobe.domain.repository

import com.movies.stegobe.app.internal_v1.form.MovieSearchParam
import com.movies.stegobe.domain.entity.MovieWithRelation
import org.apache.ibatis.annotations.Mapper

@Mapper
interface MovieWithRelationMapper {

    fun selectAll(): List<MovieWithRelation>

    fun selectById(id: Int): MovieWithRelation

    fun selectBySearchParam(searchParam: MovieSearchParam): List<MovieWithRelation>
}