package com.themovies.data

import com.themovies.data.entity.DataEntityMovies
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("3/movie/{movie_id}/recommendations")
    fun getMovies(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String): Single<DataEntityMovies>
}