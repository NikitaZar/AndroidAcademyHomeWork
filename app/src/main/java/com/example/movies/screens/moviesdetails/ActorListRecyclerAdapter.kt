package com.example.movies.screens.moviesdetails

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.data.JsonActorData

internal class ActorListRecyclerAdapter(private val actors: List<JsonActorData>, context: Context) :
    RecyclerView.Adapter<ActorListViewHolder>() {
    val context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_actor, parent, false)
        return ActorListViewHolder(itemView)
    }

    override fun getItemCount(): Int = actors.size

    override fun onBindViewHolder(holder: ActorListViewHolder, position: Int) {
        holder.bind(actors[position], context)
    }
}

class ActorListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val actorName: TextView = itemView.findViewById(R.id.actor_name)
    private val actorPic: ImageView = itemView.findViewById(R.id.actor_pic)

    fun bind(actor: JsonActorData, context: Context) {
        actorName.setText(actor.name)

        val uri = Uri.parse(actor.profile_path)
        Glide
            .with(context)
            .load(uri)
            .into(actorPic);
    }
}