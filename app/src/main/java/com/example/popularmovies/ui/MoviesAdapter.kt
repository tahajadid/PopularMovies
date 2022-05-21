package com.example.popularmovies.ui

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.popularmovies.R
import com.example.popularmovies.model.Results
import com.example.popularmovies.util.setPoster

class MoviesAdapter(
    private val context: Context?,
    private val list: List<Results>
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    /**
     * Find all the views of the list item
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        private val ratedNumber: TextView = itemView.findViewById(R.id.ratedNumber)
        private val peopleNumber: TextView = itemView.findViewById(R.id.peopleNumber)
        private val imageView : ImageView = itemView.findViewById(R.id.movieImage)

        fun bindView(item: Results, position: Int, context: Context?) {
            movieTitle.text = item.title
            ratedNumber.text = item.voteAverage.toString()
            peopleNumber.text = item.voteCount.toString()
            setPoster().setImageGlid(context!!, imageView,item.posterPath.toString())
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bindView(item, position, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.custom_movie, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

}
