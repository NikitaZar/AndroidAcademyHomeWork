package com.example.movies

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movies.data.GenresData
import com.example.movies.data.JsonMovieData
import com.example.movies.screens.moviesdetails.MoviesDetailsFragment
import com.example.movies.screens.movieslist.MoviesListFragment


class MainActivity : AppCompatActivity() {

    //TODO: Coroutines

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragments_container, MoviesListFragment())
                .commit()
        }
    }

    fun showMovie(movie: JsonMovieData, context: Context) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragments_container, MoviesDetailsFragment(movie, GenresData(context), backListener = {goBack()}))
            .addToBackStack(null)
            .commit()
    }

    private fun goBack() {
        supportFragmentManager.popBackStack()
    }
}









