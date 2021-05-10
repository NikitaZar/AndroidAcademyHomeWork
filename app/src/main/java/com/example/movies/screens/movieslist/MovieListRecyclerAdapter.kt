package com.example.movies.screens.movieslist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.data.MovieData
import com.example.movies.R
import me.zhanghai.android.materialratingbar.MaterialRatingBar
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import com.example.movies.data.JsonMovieData

internal class MovieListRecyclerAdapter(
    private val movies: List<JsonMovieData>,
    private val itemClickListener: () -> Unit
) : RecyclerView.Adapter<MovieListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_movie, parent, false)
        return MovieListViewHolder(itemView)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            itemClickListener()
        }

        holder.bind(movies[position])
    }
}

class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val movieName: TextView = itemView.findViewById(R.id.movie_name)
    private val moviePic: ImageView = itemView.findViewById(R.id.movie_pic)
    private val movieAge: TextView = itemView.findViewById(R.id.movie_age)
    private val movieLike: ImageView = itemView.findViewById(R.id.movie_like)
    private val ratingBar: MaterialRatingBar = itemView.findViewById(R.id.ratingBar)
    private val movieReviews: TextView = itemView.findViewById(R.id.movie_reviews)
    private val movieGenre: TextView = itemView.findViewById(R.id.movie_genre)
    private val duration: TextView = itemView.findViewById(R.id.duration)
    val res: Resources = itemView.resources

    fun bind(movie: JsonMovieData) {
        movieName.setText(movie.title)
        //moviePic.setImageResource(movie.picSrc)
        //movieAge.setText("${movie.age}+")

        /*
        if (movie.hasLike)
            movieLike.visibility = View.VISIBLE
        else movieLike.visibility = View.INVISIBLE
        */

        ratingBar.rating = movie.vote_average / 2
        movieReviews.setText(movie.vote_count.toString())
        movieGenre.setText(movie.genre_ids.toString()) //TODO
        duration.setText("${movie.runtime} min")
    }
}