package com.example.popularmovies.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.popularmovies.R
import com.example.popularmovies.model.Results

class MainActivity : AppCompatActivity() {

    private lateinit var moviesAdapter: MoviesAdapter
    var listMovies: MutableList<Results> = ArrayList()
    var viewModel = MoviesViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getMovies()

        var index = 0

        viewModel.responseGetMovies.observe(this) {
            it?.forEach {
                listMovies.add(index, it)
                Log.d("AllValues", "==== TITLE " + it.title.toString())
                index++
            }

            setData()
        }
    }

    fun setData() {
        moviesAdapter = MoviesAdapter(this, listMovies)
        findViewById<RecyclerView>(R.id.listofMovies).apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = moviesAdapter
        }
    }
}
