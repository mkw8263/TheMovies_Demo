package com.themovies.domain

import com.themovies.domain.entitiy.DomainEntityMovie
import io.reactivex.Single

interface MovieRepository {
    fun getMovies(movieId: Int): Single<List<DomainEntityMovie>>
}