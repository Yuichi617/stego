package com.movies.stegobe.domain.repository

import com.movies.stegobe.domain.entity.MovieWithRelation
import com.movies.stegobe.domain.selector.MovieSelector
import org.apache.ibatis.annotations.Mapper

@Mapper
interface MovieWithRelationMapper {

    fun selectBySearchParam(selector: MovieSelector): List<MovieWithRelation>

    fun selectById(id: Int): MovieWithRelation?
}
