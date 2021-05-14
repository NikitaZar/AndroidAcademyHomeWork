package com.example.movies.screens.movieslist

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.MainActivity
import com.example.movies.R
import com.example.movies.api.JsonParser
import com.example.movies.data.GenresData
import com.example.movies.data.getMovie

class MoviesListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    private var id = 0L

    private fun onMovieClick(context: Context, id: Long) {
        Log.e("id", id.toString())
        val movieData = getMovie.getMovieById(context, 671039) //TODO
        (activity as MainActivity).showMovie(movieData, context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = requireContext()
        val moviesList = JsonParser(context).moviesData

        recyclerView = view.findViewById(R.id.recyclerView_details)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter =
            MovieListRecyclerAdapter(
                moviesList,
                GenresData(context),
                context,
                itemClickListener = { onMovieClick(context, id) })
    }
}


