package com.tahn.trainning.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id : String = "",

    @SerializedName("title")
    val title : String = "",

    @SerializedName("overview")
    val overview : String = "",

    @SerializedName("poster_path")
    val poster : String = "",

    @SerializedName("release_date")
    val release_date: String = "",

    @SerializedName("vote_average")
    val vote_average: String = "",

    @SerializedName("backdrop_path")
    val backdrop_path: String = ""
)