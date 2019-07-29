package com.themovies.data.mapper

interface Mapper<E, D> {
    fun mapFromEntity(type: E): D
}
