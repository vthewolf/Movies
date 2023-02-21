package com.example.movies.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbService {

    @GET("movie/popular")
    fun listPopularMovies(@Query("api_key") apiKey: String): Call<MovieDbResult>
}