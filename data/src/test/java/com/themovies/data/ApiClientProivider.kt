package com.themovies.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientProivider {
    fun getMoviesApiClient(): MovieService {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        val client = okhttp3.OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        val retorift = Retrofit.Builder()
            .client(client)
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
//            .baseUrl("https://api.themoviedb.org/3/movie/550/recommendations?api_key=1edeb9ac8156f4fd1ebd4bb7081667a1")


        return retorift.create(MovieService::class.java)
    }

    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }
}
