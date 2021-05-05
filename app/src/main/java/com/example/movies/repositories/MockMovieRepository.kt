package com.example.movies.repositories

import com.example.movies.data.ActorData
import com.example.movies.data.MovieData
import com.example.movies.R

object MockMovieRepository {
    fun generateMovies(): List<MovieData> {
        return listOf(
            MovieData(
                R.string.avengers_end_game_line,
                R.drawable.movie_,
                13,
                false,
                4.0F,
                1,
                R.string.action_adventure_fantasy,
                137
            ),

            MovieData(
                R.string.tenet,
                R.drawable.movie_2,
                16,
                true,
                5.0F,
                98,
                R.string.action_sci_fi_thriller,
                97
            ),

            MovieData(
                R.string.black_window,
                R.drawable.movie_3,
                13,
                false,
                4.0F,
                228,
                R.string.action_adventure_sci_fi,
                102
            ),

            MovieData(
                R.string.wonder_woman_1984,
                R.drawable.movie_4,
                13,
                false,
                5.0F,
                74,
                R.string.action_adventure_fantasy,
                120
            )
        )
    }

    fun generateActors(): List<ActorData> {
        return listOf(
            ActorData(
                R.string.robert_downey_jr,
                R.drawable.movie
            ),
            ActorData(
                R.string.chris_evans_text,
                R.drawable.movie1
            ),
            ActorData(
                R.string.mark_ruffalo_text,
                R.drawable.movie2
            ),
            ActorData(
                R.string.chris_hemsworth_text,
                R.drawable.movie3
            )
        )
    }
}