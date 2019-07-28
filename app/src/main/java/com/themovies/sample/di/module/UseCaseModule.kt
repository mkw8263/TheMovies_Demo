package com.themovies.sample.di.module

import com.themovies.data.MovieRepository
import com.themovies.domain.usecase.MovieUseCase
import com.themovies.domain.mapper.MoviesMapper
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [RepositoryModule::class])
class UseCaseModule {
    @Provides
    fun provideMovieUseCase(
        @Named("MovieRepositoryImpl") movieRepository: MovieRepository, moviesMapper: MoviesMapper
    ): MovieUseCase {
        return MovieUseCase(movieRepository, moviesMapper)
    }
}