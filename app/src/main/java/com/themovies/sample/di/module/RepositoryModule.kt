package com.themovies.sample.di.module

import android.content.Context
import com.themovies.data.MovieRepository
import com.themovies.data.MovieRepositoryImpl
import com.themovies.data.MovieService
import com.themovies.sample.R
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RepositoryModule {
    @Provides
    @Named("MovieRepositoryImpl")
    fun provideMovieRepository(
        movieService: MovieService,
        context: Context
    ): MovieRepository {
        return MovieRepositoryImpl(movieService, context.getString(R.string.api_key))
    }
}