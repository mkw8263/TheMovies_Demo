package com.themovies.sample.di

import android.content.Context
import com.themovies.sample.MovieApplication
import com.themovies.sample.di.module.ActivityBindingModule
import com.themovies.sample.di.module.NetWorkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        NetWorkModule::class]
)
interface MovieComponent : AndroidInjector<MovieApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): MovieComponent
    }
}