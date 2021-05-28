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
import com.example.movies.data.MovieData
import kotlinx.coroutines.*

class MoviesListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieListRecyclerAdapter: MovieListRecyclerAdapter
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        coroutineScope.launch {
            Log.i("step", "onAttach start")
            movieListRecyclerAdapter.setMovie(
                JsonParser().parseMovie(
                    requireContext(),
                    "data.json",
                    "genres.json",
                    "people.json"
                )
            )
            Log.i("step", "onAttach finish")
        }
    }

/*    override fun onStart() {
        super.onStart()
        coroutineScope.launch {
            movieListRecyclerAdapter.setMovie(
                JsonParser().parseMovie(
                    requireContext(),
                    "data.json",
                    "genres.json",
                    "people.json"
                )
            )
        }
    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    private fun onMovieClick(movie: MovieData) {
        (activity as MainActivity).showMovie(movie, requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("step", "onViewCreated start")

        val context = requireContext()

        recyclerView = view.findViewById(R.id.recyclerView_details)
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        movieListRecyclerAdapter =
            MovieListRecyclerAdapter(context, itemClickListener = { onMovieClick(it) })
        recyclerView.adapter = movieListRecyclerAdapter
        Log.i("step", "onViewCreated finish")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        coroutineScope.cancel()
    }
}


