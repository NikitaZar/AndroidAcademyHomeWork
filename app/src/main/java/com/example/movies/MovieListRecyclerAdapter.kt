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
        val movieName: TextView? = itemView.findViewById(R.id.movie_name)
        val moviePic: ImageView? = itemView.findViewById(R.id.movie_pic)
        val movieAge: TextView? = itemView.findViewById(R.id.movie_age)
        val movieLike: ImageView? = itemView.findViewById(R.id.movie_like)
        val ratingBar: MaterialRatingBar? = itemView.findViewById(R.id.ratingBar)
        val movieReviews: TextView? = itemView.findViewById(R.id.movie_reviews)
        val movieGenre: TextView? = itemView.findViewById(R.id.movie_genre)
        val duration: TextView? = itemView.findViewById(R.id.duration)
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

        holder.movieName?.setText(movies[position].name)
        holder.moviePic?.setImageResource(movies[position].picSrc)
        holder.movieAge?.text = movies[position].age.toString().plus("+")

        if (movies[position].hasLike)
            holder.movieLike?.visibility = View.VISIBLE
        else holder.movieLike?.visibility = View.INVISIBLE

        holder.ratingBar?.rating = movies[position].rating
        holder.movieReviews?.text = movies[position].reviewsCnt.toString().plus(" reviews")
        holder.movieGenre?.setText(movies[position].genre)
        holder.duration?.text = movies[position].duration.toString().plus(" min")
    }
}