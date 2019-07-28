package com.themovies.domain.mapper

interface Mapper<E, D> {
    fun mapFromEntity(type: E): D
}
