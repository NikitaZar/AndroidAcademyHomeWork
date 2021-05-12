package com.example.movies.screens.movieslist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.MainActivity
import com.example.movies.repositories.MockMovieRepository
import com.example.movies.R
import com.example.movies.api.JsonParser
import com.example.movies.data.GenresData

class MoviesListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    private fun onMovieClick() {
        (activity as MainActivity).showFirstMovie()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = requireContext()
        val moviesList = JsonParser(context).moviesData
        val genresData = GenresData()

        //TODO: transfer to other thread
        val genresList = JsonParser(context).genresData
        genresData.initGenres(genresList)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter =
            MovieListRecyclerAdapter(
                moviesList,
                genresData,
                context,
                itemClickListener = { onMovieClick() })
    }
}


