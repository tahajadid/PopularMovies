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

    fun getMovies() = uiCoroutine {

        val popularMoviesAPI = RetrofitClient.getInstance().create(PopularMoviesAPI::class.java)
        // launching a new coroutine

        val result = popularMoviesAPI.getMovies()

        if (result != null) {
            _responseGetMovies.value = result.body()?.results
            Log.d("AllValues", result.body()?.results?.size.toString())
        }
    }
}
