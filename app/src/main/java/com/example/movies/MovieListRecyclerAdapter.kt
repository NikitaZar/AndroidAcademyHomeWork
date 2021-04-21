package com.example.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.zhanghai.android.materialratingbar.MaterialRatingBar

class MovieListRecyclerAdapter(
    private val listener: () -> Unit,
    private val movies: List<MovieData>
) :
    RecyclerView.Adapter<MovieListRecyclerAdapter.MovieListViewHolder>() {
    class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var movieName: TextView? = null
        var moviePic: ImageView? = null
        var movieAge: TextView? = null
        var movieLike: ImageView? = null
        var ratingBar: MaterialRatingBar? = null
        var movieReviews: TextView? = null
        var movieGenre: TextView? = null
        var duration: TextView? = null

        init {
            movieName = itemView.findViewById(R.id.movie_name)
            moviePic = itemView.findViewById(R.id.movie_pic)
            movieAge = itemView.findViewById(R.id.movie_age)
            movieLike = itemView.findViewById(R.id.movie_like)
            ratingBar = itemView.findViewById(R.id.ratingBar)
            movieReviews = itemView.findViewById(R.id.movie_reviews)
            movieGenre = itemView.findViewById(R.id.movie_genre)
            duration = itemView.findViewById(R.id.duration)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_movie, parent, false)
        return MovieListViewHolder(itemView)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            listener()
        }

        holder.movieName?.text = movies[position].name
        holder.moviePic?.setImageResource(movies[position].picSrc)
        holder.movieAge?.text = movies[position].age.toString().plus("+")

        if (movies[position].hasLike)
            holder.movieLike?.visibility = View.VISIBLE
        else holder.movieLike?.visibility = View.INVISIBLE

        holder.ratingBar?.rating = movies[position].rating
        holder.movieReviews?.text = movies[position].reviewsCnt.toString().plus(" reviews")
        holder.movieGenre?.text = movies[position].genre
        holder.duration?.text = movies[position].duration.toString().plus(" min")
    }
}