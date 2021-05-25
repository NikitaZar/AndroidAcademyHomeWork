package com.example.movies

import MoviesDetailsFragment
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movies.data.JsonMovieData
import com.example.movies.data.MovieData

import com.example.movies.screens.movieslist.MoviesListFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragments_container, MoviesListFragment())
                .commit()
        }
    }

    fun showMovie(movie: MovieData, context: Context) {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragments_container,
                MoviesDetailsFragment(movie,
                    backListener = { goBack() })
            )
            .addToBackStack(null)
            .commit()
    }

    private fun goBack() {
        supportFragmentManager.popBackStack()
    }
}









