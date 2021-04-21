package com.example.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorListRecyclerAdapter(private val actors: List<ActorData>) :
    RecyclerView.Adapter<ActorListRecyclerAdapter.ActorListViewHolder>() {
    class ActorListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var actorName: TextView? = null
        var actorPic: ImageView? = null

        init {
            actorName = itemView.findViewById(R.id.actor_name)
            actorPic = itemView.findViewById(R.id.actor_pic)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_actor, parent, false)
        return ActorListRecyclerAdapter.ActorListViewHolder(itemView)
    }

    override fun getItemCount(): Int = actors.size

    override fun onBindViewHolder(holder: ActorListViewHolder, position: Int) {
        holder.actorName?.text = actors[position].name
        holder.actorPic?.setImageResource(actors[position].picSrc)
    }
}
