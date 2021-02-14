package com.example.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), FragmentMoviesList.TransactionsFragmentClicks {

    //слушаем клики главной активити
    private val rootFragment =
        FragmentMoviesList().apply { setClickListener(this@MainActivity) }


    //создаем объект фрагмента
    private val detailsFragment = FragmentMoviesDetails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Прверяем, что фрагмент еще не создан (например поворот экрана)
        //if (savedInstanceState == null) {
            //рутовая транзакция
            supportFragmentManager.beginTransaction()
                .add(R.id.fragments_container, rootFragment)
                .commit()
        //}
    }


    //транзакция на первый фильм
    override fun showFirstMovie() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager
            .beginTransaction()

        fragmentTransaction.apply {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(R.id.fragments_container, detailsFragment)
                .commit()
        }
    }


}



