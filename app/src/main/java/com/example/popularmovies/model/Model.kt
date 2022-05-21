package com.example.popularmovies.model

import com.google.gson.annotations.SerializedName

data class Model (

    @SerializedName("page") var page : Int? = null,
    @SerializedName("results") var results : ArrayList<Results> = arrayListOf(),
    @SerializedName("total_pages") var totalPages : Int? = null,
    @SerializedName("total_results") var totalResults : Int?  = null

)
