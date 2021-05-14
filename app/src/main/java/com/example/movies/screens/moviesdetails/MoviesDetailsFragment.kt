package com.example.movies.screens.moviesdetails

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.repositories.MockMovieRepository
import com.example.movies.R
import com.example.movies.api.JsonParser
import com.example.movies.data.GenresData
import com.example.movies.data.JsonMovieData

class MoviesDetailsFragment(
    movieData: JsonMovieData,
    genresData: GenresData,
    backListener: () -> Unit
) : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieName: TextView
    private lateinit var movieAge: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var movieReviews: TextView
    private lateinit var movieGenre: TextView
    private lateinit var moviePic: ImageView
    private lateinit var backBt: TextView
    private val backListener = backListener

    private val movieData = movieData
    private val genresData = genresData


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = requireContext()

        recyclerView = view.findViewById(R.id.recyclerView_details)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = ActorListRecyclerAdapter(JsonParser(context).actorsData, context)

        movieName = view.findViewById(R.id.movie_name_details)
        movieName.text = movieData.title

        //movieAge = view.findViewById(R.id.movie_age_details)
        //movieAge.text = movieData.age

        ratingBar = view.findViewById(R.id.ratingBar_details)
        ratingBar.rating - movieData.vote_average / 2

        movieReviews = view.findViewById(R.id.movie_reviews_details)
        movieReviews.setText(
            context.resources.getQuantityString(
                R.plurals.review,
                movieData.vote_count,
                movieData.vote_count
            )
        )

        movieGenre = view.findViewById(R.id.movie_genre_details)
        movieGenre.setText(genresData.getGenres(movieData.genre_ids))

        moviePic = view.findViewById(R.id.movie_pic_details)
        val uri = Uri.parse(movieData.backdrop_path)
        Glide
            .with(context)
            .load(uri)
            .into(moviePic);

        backBt = view.findViewById(R.id.activity_movie_details_back_button)
        backBt.setOnClickListener { backListener() }

    }
}