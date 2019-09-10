package com.tahn.trainning.api

import com.tahn.trainning.model.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{
    @GET("movie/now_playing")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Call<MoviesResponse>
}