package com.example.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesList : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun doClick() {
            (activity as MainActivity).showFirstMovie()
        }

        val listener: () -> Unit = { doClick() }

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = GridLayoutManager(context, 2)
        recyclerView?.adapter = MovieListRecyclerAdapter(listener, ListGenerator.generateMovies())
    }
}


