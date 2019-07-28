package com.themovies.sample.di.module

import androidx.lifecycle.ViewModelProvider
import com.themovies.sample.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
}