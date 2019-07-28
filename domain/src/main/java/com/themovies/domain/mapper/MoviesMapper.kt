package com.themovies.domain.mapper

import com.themovies.data.entity.DataEntityMovies
import com.themovies.domain.entitiy.DomainEntityMovie
import javax.inject.Inject

class MoviesMapper @Inject constructor() :
    Mapper<DataEntityMovies, List<DomainEntityMovie>> {
    override fun mapFromEntity(type: DataEntityMovies): List<DomainEntityMovie> {
        return type.results.map {
            with(it) {
                DomainEntityMovie(
                    adult,
                    backdropPath,
                    genreIds,
                    id,
                    originalLanguage,
                    originalTitle,
                    overview,
                    popularity,
                    posterPath,
                    releaseDate,
                    title,
                    video,
                    voteAverage,
                    voteCount
                )
            }
        }
    }
}
