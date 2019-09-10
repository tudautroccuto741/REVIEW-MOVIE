package com.tahn.trainning.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private val baseurl = "http://api.themoviedb.org/3/"

    fun getClient() : Retrofit = Retrofit
        .Builder()
        .baseUrl(baseurl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}