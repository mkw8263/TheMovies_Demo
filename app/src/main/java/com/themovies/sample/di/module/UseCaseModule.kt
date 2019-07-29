package com.themovies.sample.di.module

import com.themovies.domain.MovieRepository
import com.themovies.domain.usecase.MovieUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [RepositoryModule::class])
class UseCaseModule {
    @Provides
    fun provideMovieUseCase(
        @Named("MovieRepositoryImpl") movieRepository: MovieRepository
    ): MovieUseCase {
        return MovieUseCase(movieRepository)
    }
}