package com.themovies.data

import com.themovies.common.networkThreadWithMainThread
import com.themovies.data.entity.DataEntityMovies
import io.reactivex.Single
import javax.inject.Inject

interface MovieRepository : Repository {
    fun getMovies(movieId: Int): Single<DataEntityMovies>
}

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val apiKey: String
) : MovieRepository {
    override fun getMovies(movieId: Int): Single<DataEntityMovies> {
        return movieService.getMovies(movieId, apiKey).networkThreadWithMainThread()
    }
}
