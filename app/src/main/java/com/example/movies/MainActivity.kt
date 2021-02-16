package com.example.movies

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragments_container, FragmentMoviesList())
                .addToBackStack(null)
                .commit()
            Log.d(TAG, "add Root")
        }
    }

    fun showFirstMovie() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragments_container, FragmentMoviesDetails())
            .addToBackStack(null)
            .commit()
        Log.d(TAG, "add Details")
    }

    companion object {
        private const val TAG = "Movie"
        private const val FRAGMENT_INSTANCE_NAME = "detailsFragment"
    }

}



