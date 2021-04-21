package com.example.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesList : Fragment() {
    private var recyclerView: RecyclerView? = null
    private lateinit var movieView1: View
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
        recyclerView?.layoutManager = GridLayoutManager(context,2)
        recyclerView?.adapter = MovieListRecyclerAdapter(listener, generateMovies())
    }

    private fun generateMovies(): List<MovieData> {
        return listOf(
            MovieData(
                getString(R.string.avengers_end_game_line),
                R.drawable.movie_,
                13,
                false,
                4.0F,
                228,
                getString(R.string.action_adventure_fantasy),
                137
            ),

            MovieData(
                getString(R.string.tenet),
                R.drawable.movie_2,
                16,
                true,
                5.0F,
                98,
                getString(R.string.action_sci_fi_thriller),
                97
            ),

            MovieData(
                getString(R.string.black_window),
                R.drawable.movie_3,
                13,
                false,
                4.0F,
                228,
                getString(R.string.action_adventure_sci_fi),
                102
            ),

            MovieData(
                getString(R.string.wonder_woman_1984),
                R.drawable.movie_4,
                13,
                false,
                5.0F,
                74,
                getString(R.string.action_adventure_fantasy),
                120
            )
        )
    }
}


