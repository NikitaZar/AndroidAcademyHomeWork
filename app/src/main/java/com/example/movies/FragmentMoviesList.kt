package com.example.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentMoviesList : Fragment() {

    private lateinit var movieView1: View
    private var listener: TransactionsFragmentClicks? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieView1 = view.findViewById<View>(R.id.first_movie).apply {
            setOnClickListener { listener?.showFirstMovie() }
        }


    }

    fun setClickListener(l: TransactionsFragmentClicks?) {
        listener = l
    }


    interface TransactionsFragmentClicks {
        fun showFirstMovie()
//        fun showSecondMovie()
//        fun showThirdMovie()
//        fun showFourthMovie()

    }

}


