package tahadeta.example.popularmovies.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class setPoster {

    fun setImageGlid(context: Context, imageView: ImageView, endString: String) {
        Glide.with(context).load("https://image.tmdb.org/t/p/original$endString").into(imageView)
    }
}
