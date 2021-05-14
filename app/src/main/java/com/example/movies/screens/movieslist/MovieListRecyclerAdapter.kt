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
import com.example.movies.data.GenresData
import com.example.movies.data.JsonMovieData

internal class MovieListRecyclerAdapter(
    private val movies: List<JsonMovieData>,
    private val genresData: GenresData,
    private val context: Context,
    private val itemClickListener: (id: Long) -> Unit
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
            itemClickListener(movies[position].id)
        }

        holder.bind(movies[position], context, genresData)
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

    fun bind(movie: JsonMovieData, context: Context, genresData: GenresData) {
        movieName.setText(movie.title)

        val uri = Uri.parse(movie.poster_path)
        Glide
            .with(context)
            .load(uri)
            .into(moviePic);

        //movieAge.setText("${movie.age}+")

        /*
        if (movie.hasLike)
            movieLike.visibility = View.VISIBLE
        else movieLike.visibility = View.INVISIBLE
        */

        ratingBar.rating = movie.vote_average / 2

        movieReviews.setText(
            context.resources.getQuantityString(
                R.plurals.review,
                movie.vote_count,
                movie.vote_count
            )
        )

        movieGenre.setText(genresData.getGenres(movie.genre_ids))

        duration.setText("${movie.runtime} min")
    }
}