package com.themovies.data

import com.themovies.common.networkThreadWithMainThread
import com.themovies.data.mapper.MoviesMapper
import com.themovies.domain.MovieRepository
import com.themovies.domain.entitiy.DomainEntityMovie
import io.reactivex.Single
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val moviesMapper: MoviesMapper,
    private val apiKey: String
) : MovieRepository {
    override fun getMovies(movieId: Int): Single<List<DomainEntityMovie>> {
        return movieService.getMovies(movieId, apiKey)
            .networkThreadWithMainThread()
            .map(moviesMapper::mapFromEntity)
    }
}
