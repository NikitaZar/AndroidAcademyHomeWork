package com.example.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesDetails : Fragment() {
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView?.adapter = ActorListRecyclerAdapter(generateActors())
    }

    private fun generateActors(): List<ActorData> {
        return listOf(
            ActorData(
                getString(R.string.robert_downey_jr),
                R.drawable.movie
            ),
            ActorData(
                getString(R.string.chris_evans_text),
                R.drawable.movie1
            ),
            ActorData(
                getString(R.string.mark_ruffalo_text),
                R.drawable.movie2
            ),
            ActorData(
                getString(R.string.chris_hemsworth_text),
                R.drawable.movie3
            )
        )
    }
}