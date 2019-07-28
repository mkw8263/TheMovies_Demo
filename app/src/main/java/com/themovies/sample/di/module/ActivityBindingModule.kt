package com.themovies.sample.di.module

import com.themovies.presentation.ui.detail.MovieDetailActivity
import com.themovies.presentation.ui.movies.MoviesActivity
import com.themovies.sample.di.module.movies.MoviesActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            MoviesActivityModule::class
        ]
    )
    abstract fun bindMoviesActivity(): MoviesActivity

    @ContributesAndroidInjector
    abstract fun bindMovieDetailActivity(): MovieDetailActivity
}