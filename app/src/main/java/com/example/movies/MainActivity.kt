package com.example.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movies.screens.moviesdetails.MoviesDetailsFragment
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

    fun showFirstMovie() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragments_container, MoviesDetailsFragment())
            .addToBackStack(null)
            .commit()
    }
}









