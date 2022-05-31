package com.example.popularmovies.net

import com.example.popularmovies.model.Model
import com.example.popularmovies.util.Constants.TOP_RATED_WITH_TOKEN
import com.example.popularmovies.util.Constants.TRENDING_WITH_TOKEN
import com.example.popularmovies.util.Constants.UPCOMING_WITH_TOKEN
import retrofit2.Response
import retrofit2.http.GET

interface PopularMoviesAPI {

    @GET(TOP_RATED_WITH_TOKEN)
    suspend fun getMovies(): Response<Model>

    @GET(TRENDING_WITH_TOKEN)
    suspend fun getTrendingMovies(): Response<Model>

    @GET(UPCOMING_WITH_TOKEN)
    suspend fun getUpcomingMovies(): Response<Model>
}
