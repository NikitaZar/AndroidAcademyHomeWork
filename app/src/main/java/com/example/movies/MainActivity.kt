package com.example.movies

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity(), FragmentMoviesList.TransactionsFragmentClicks {

    //слушаем клики главной активити
    private var rootFragment =
        FragmentMoviesList().apply { setClickListener(this@MainActivity)
        }


    //создаем объект фрагмента
    private val detailsFragment = FragmentMoviesDetails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragments_container, rootFragment)
            .addToBackStack(null)
            .commit()
        Log.d(TAG, "add Root")


        //Прверяем, что фрагмент еще не создан (например поворот экрана)
        val targetFm = supportFragmentManager.findFragmentByTag(FRAGMENT_INSTANCE_NAME)
        if (targetFm!=null) {
            val targetFm = FragmentMoviesDetails()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragments_container, targetFm, FRAGMENT_INSTANCE_NAME)
                //.addToBackStack(null)
                .commit()
            Log.d(TAG, "add Details")
            //}else {
        }



    }

    //транзакция на первый фильм
    override fun showFirstMovie() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager
            .beginTransaction()

        fragmentTransaction.apply {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(R.id.fragments_container, detailsFragment, FRAGMENT_INSTANCE_NAME)
                .commit()
            Log.d(TAG, "add Details")
        }
    }
companion object{
    private const val TAG = "Movie"
    private const val  FRAGMENT_INSTANCE_NAME = "detailsFragment"
}

}



