package com.example.movies.screens.movieslist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import me.zhanghai.android.materialratingbar.MaterialRatingBar
import android.content.res.Resources
import android.net.Uri
import com.bumptech.glide.Glide
import com.example.movies.data.MovieData

internal class MovieListRecyclerAdapter(
    private val context: Context,
    private val itemClickListener: (MovieData) -> Unit
) : RecyclerView.Adapter<MovieListViewHolder>() {

    private var movies = emptyList<MovieData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_movie, parent, false)
        return MovieListViewHolder(itemView)
    }

    override fun getItemCount() : Int{
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            itemClickListener(movies[position])
        }

        holder.bind(movies[position], context)
    }

    fun setMovie(movies: List<MovieData>){
        this.movies = movies
    }

}

class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val movieName: TextView = itemView.findViewById(R.id.movie_name)
    private val moviePic: ImageView = itemView.findViewById(R.id.movie_pic)
    private val movieAge: TextView = itemView.findViewById(R.id.movie_age)
    private val movieLike: ImageView = itemView.findViewById(R.id.movie_like)
    private val ratingBar: MaterialRatingBar = itemView.findViewById(R.id.ratingBar_details)
    private val movieReviews: TextView = itemView.findViewById(R.id.movie_reviews)
    private val movieGenre: TextView = itemView.findViewById(R.id.movie_genre)
    private val duration: TextView = itemView.findViewById(R.id.duration)
    val res: Resources = itemView.resources

    fun bind(movie: MovieData, context: Context) {
        movieName.text = movie.name

        val uri = Uri.parse(movie.posterPic)
        Glide
            .with(context)
            .load(uri)
            .into(moviePic);

        movieAge.text = "${movie.age}+"


        if (movie.hasLike)
            movieLike.visibility = View.VISIBLE
        else movieLike.visibility = View.INVISIBLE


        ratingBar.rating = movie.rating

        movieReviews.text = context.resources.getQuantityString(
            R.plurals.review,
            movie.reviews,
            movie.reviews
        )

        movieGenre.text = movie.genres.toString()

        duration.text = "${movie.duration} min"
    }
}