package com.example.popularmovies.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.popularmovies.R
import com.example.popularmovies.model.Results

class MainActivity : AppCompatActivity() {

    private lateinit var moviesAdapter: MoviesAdapter
    var listMovies: MutableList<Results> = ArrayList()
    var viewModel = MoviesViewModel()
    private var isHide = true
    var index = 0
    private lateinit var checkboxOne: CheckBox
    private lateinit var checkboxTwo: CheckBox
    private lateinit var imageFilter: ImageView
    private lateinit var recylerView: RecyclerView
    private lateinit var filterContainer: ConstraintLayout
    private lateinit var filterView: View
    private lateinit var trendingMovie: PlanSliderItemView
    private lateinit var upcomingMovie: PlanSliderItemView
    private lateinit var popularMovie: PlanSliderItemView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkboxOne = findViewById(R.id.check_box_one)
        checkboxTwo = findViewById(R.id.check_box_two)
        imageFilter = findViewById(R.id.filterImage)
        recylerView = findViewById(R.id.listofMovies)
        filterContainer = findViewById(R.id.filter_container)
        filterView = findViewById(R.id.view3)
        trendingMovie = findViewById(R.id.trendingMovie)
        upcomingMovie = findViewById(R.id.upcomingMovie)
        popularMovie = findViewById(R.id.popularMovie)

        trendingMovie.setOnClickListener {
            getTrendingMoviesData()
        }

        upcomingMovie.setOnClickListener {
            getUpcomingMoviesData()
        }

        popularMovie.setOnClickListener {
            getPopularMovies()
        }

        getTrendingMoviesData()

        initView()
    }

    fun initView() {

        hideFilterView()
        showFilterView()

        filterContainer.visibility = View.GONE
        filterView.visibility = View.GONE

        imageFilter.setOnClickListener {
            if (isHide) {
                isHide = false
                hideFilterView()
            } else {
                isHide = true
                showFilterView()
            }
        }

        checkboxOne.setOnCheckedChangeListener { _, isChecked ->
            when {
                isChecked -> {
                    sortDescending()
                    checkboxTwo.isChecked = false
                }
            }
        }

        checkboxTwo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sortAscending()
                checkboxOne.isChecked = false
            }
        }
    }

    fun getTrendingMoviesData() {
        viewModel.getTrendongMovies()

        trendingMovie.setChecked(true)
        upcomingMovie.setChecked(false)
        popularMovie.setChecked(false)

        viewModel.responseGetTrendingMovies.observe(this) {
            it?.forEach {
                listMovies.add(index, it)
                Log.d("AllValues", "==== TITLE " + it.title.toString())
                index++
            }

            setData()
        }
    }

    fun getUpcomingMoviesData() {
        viewModel.getUpcomingMovies()

        trendingMovie.setChecked(false)
        upcomingMovie.setChecked(true)
        popularMovie.setChecked(false)

        viewModel.responseGetUpcomingMovies.observe(this) {
            it?.forEach {
                listMovies.add(index, it)
                Log.d("AllValues", "==== TITLE " + it.title.toString())
                index++
            }

            setData()
        }
    }

    fun getPopularMovies() {
        viewModel.getMovies()

        trendingMovie.setChecked(false)
        upcomingMovie.setChecked(false)
        popularMovie.setChecked(true)

        viewModel.responseGetMovies.observe(this) {
            it?.forEach {
                listMovies.add(index, it)
                Log.d("AllValues", "==== TITLE " + it.title.toString())
                index++
            }

            setData()
        }
    }

    fun hideFilterView() {
        imageFilter.setImageResource(R.drawable.filter_on)
        val param = recylerView.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(0, 130, 0, 0)
        recylerView.layoutParams = param // Tested!! - Y
        filterContainer.visibility = View.VISIBLE
        filterView.visibility = View.VISIBLE
    }

    fun showFilterView() {
        imageFilter.setImageResource(R.drawable.filter)
        val param = recylerView.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(0, 0, 0, 0)
        recylerView.layoutParams = param // Tested!! - Y
        filterContainer.visibility = View.GONE
        filterView.visibility = View.GONE
    }

    fun sortDescending() {
        listMovies.sortByDescending {
            it.title.toString()
        }
        findViewById<RecyclerView>(R.id.listofMovies).apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = moviesAdapter
        }
    }

    fun sortAscending() {
        listMovies.sortBy {
            it.title.toString()
        }
        findViewById<RecyclerView>(R.id.listofMovies).apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = moviesAdapter
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
