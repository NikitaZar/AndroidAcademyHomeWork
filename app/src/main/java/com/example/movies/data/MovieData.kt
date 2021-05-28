package com.example.movies.data

data class MovieData(
    val name: String,
    val posterPic: String,
    val backdropPic: String,
    val rating: Float,
    val reviews: Int,
    val duration: Int,
    val overview: String,
    val age: Int,
    val hasLike: Boolean,
    val genres: List<String>,
    val actors: List<ActorData>
)