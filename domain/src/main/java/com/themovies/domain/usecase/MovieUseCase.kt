package com.themovies.domain.usecase

import com.themovies.domain.MovieRepository
import com.themovies.domain.SingleUseCase
import com.themovies.domain.entitiy.DomainEntityMovie
import io.reactivex.Single
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : SingleUseCase<MovieUseCase.Params, List<DomainEntityMovie>> {

    override fun execute(params: Params?): Single<List<DomainEntityMovie>> {
        return params?.let {
            movieRepository.getMovies(params.movieId)
        } ?: run {
            Single.never<List<DomainEntityMovie>>()
        }
    }

    data class Params(val movieId: Int)
}
