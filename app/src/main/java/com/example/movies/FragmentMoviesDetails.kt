package com.example.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class FragmentMoviesDetails: Fragment(){

    private var listener: FragmentMoviesList.TransactionsFragmentClicks? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)


    fun setClickListener(l: FragmentMoviesList.TransactionsFragmentClicks?) {
        listener = l
    }




}