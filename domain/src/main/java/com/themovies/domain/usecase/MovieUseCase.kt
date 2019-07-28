package com.themovies.domain.usecase

import com.themovies.data.MovieRepository
import com.themovies.domain.SingleUseCase
import com.themovies.domain.entitiy.DomainEntityMovie
import com.themovies.domain.mapper.MoviesMapper
import io.reactivex.Single
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val mapper: MoviesMapper
) : SingleUseCase<MovieUseCase.Params, List<DomainEntityMovie>> {

    override fun execute(params: Params?): Single<List<DomainEntityMovie>> {
        return if (params != null) {
            movieRepository.getMovies(params.movieId)
                .flatMap {
                    Single.just(mapper.mapFromEntity(it))
                }
        } else {
            Single.never()
        }
    }

    data class Params(val movieId: Int)
}