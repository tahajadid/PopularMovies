package com.example.popularmovies.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.popularmovies.model.Results
import com.example.popularmovies.net.PopularMoviesAPI
import com.example.popularmovies.net.RetrofitClient
import com.example.popularmovies.util.BaseViewModel

class MoviesViewModel : BaseViewModel() {

    private val _responseGetMovies = MutableLiveData<List<Results>?>()
    val responseGetMovies: LiveData<List<Results>?> = _responseGetMovies

    private val _responseGetTrendingMovies = MutableLiveData<List<Results>?>()
    val responseGetTrendingMovies: LiveData<List<Results>?> = _responseGetTrendingMovies

    private val _responseGetUpcomingMovies = MutableLiveData<List<Results>?>()
    val responseGetUpcomingMovies: LiveData<List<Results>?> = _responseGetUpcomingMovies

    fun getMovies() = uiCoroutine {

        val popularMoviesAPI = RetrofitClient.getInstance().create(PopularMoviesAPI::class.java)
        // launching a new coroutine

        val result = popularMoviesAPI.getMovies()

        if (result != null) {
            _responseGetMovies.value = result.body()?.results
            Log.d("AllValues", result.body()?.results?.size.toString())
        }
    }

    fun getTrendongMovies() = uiCoroutine {

        val popularMoviesAPI = RetrofitClient.getInstance().create(PopularMoviesAPI::class.java)
        // launching a new coroutine

        val result = popularMoviesAPI.getTrendingMovies()

        if (result != null) {
            _responseGetTrendingMovies.value = result.body()?.results
            Log.d("AllValues", result.body()?.results?.size.toString())
        }
    }

    fun getUpcomingMovies() = uiCoroutine {

        val popularMoviesAPI = RetrofitClient.getInstance().create(PopularMoviesAPI::class.java)
        // launching a new coroutine

        val result = popularMoviesAPI.getUpcomingMovies()

        if (result != null) {
            _responseGetUpcomingMovies.value = result.body()?.results
            Log.d("AllValues", result.body()?.results?.size.toString())
        }
    }
}
