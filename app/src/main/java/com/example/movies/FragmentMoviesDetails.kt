package com.example.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class FragmentMoviesDetails: Fragment(){

    private var listener: FragmentMoviesList.TransactionsFragmentClicks? = null
    var fragmentId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
       /*
        arguments?.let {
            fragmentId = it.getString(PARAM_ID)
        }

        */
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)


    fun setClickListener(l: FragmentMoviesList.TransactionsFragmentClicks?) {
        listener = l
    }

    companion object {
        private const val PARAM_ID = "fragment_MovieDetails"

        fun newInstance(
            id: String
        ): FragmentMoviesDetails {
            val fragment = FragmentMoviesDetails()
            val args = Bundle()
            args.putString(PARAM_ID, id)
            fragment.arguments = args
            return fragment
        }
    }
}