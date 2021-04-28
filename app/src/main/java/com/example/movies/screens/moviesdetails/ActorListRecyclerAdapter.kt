package com.example.movies.screens.moviesdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.data.ActorData

internal class ActorListRecyclerAdapter(private val actors: List<ActorData>) :
    RecyclerView.Adapter<ActorListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_actor, parent, false)
        return ActorListViewHolder(itemView)
    }

    override fun getItemCount(): Int = actors.size

    override fun onBindViewHolder(holder: ActorListViewHolder, position: Int) {
        holder.bind(actors[position])
    }
}

class ActorListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val actorName: TextView = itemView.findViewById(R.id.actor_name)
    private val actorPic: ImageView = itemView.findViewById(R.id.actor_pic)

    fun bind(actor: ActorData) {
        actorName.setText(actor.name)
        actorPic.setImageResource(actor.picSrc)
    }
}