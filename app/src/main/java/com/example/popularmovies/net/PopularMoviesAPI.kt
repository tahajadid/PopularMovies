package com.example.popularmovies.net

import com.example.popularmovies.model.Model
import com.example.popularmovies.util.Constants.TOP_RATED_WITH_TOKEN
import retrofit2.Response
import retrofit2.http.GET

interface PopularMoviesAPI {

    @GET(TOP_RATED_WITH_TOKEN)
    suspend fun getMovies(): Response<Model>
}
