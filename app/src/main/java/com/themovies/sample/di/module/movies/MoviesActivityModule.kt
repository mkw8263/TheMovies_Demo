package com.themovies.sample.di.module.movies

import androidx.lifecycle.ViewModel
import com.themovies.presentation.ui.movies.MovieViewModel
import com.themovies.sample.di.module.UseCaseModule
import com.themovies.sample.di.qualifier.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [UseCaseModule::class])
abstract class MoviesActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun bindViewModel(viewModel: MovieViewModel): ViewModel
}