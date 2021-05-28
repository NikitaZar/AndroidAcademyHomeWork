package com.example.movies.data

import kotlinx.serialization.Serializable

@Serializable
data class JsonMovieData(
    val popularity: Float,
    val vote_count: Int,
    val video: Boolean,
    val poster_path: String,
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String,
    val original_language: String,
    val original_title: String,
    val runtime: Int,
    val genre_ids: List<Int>,
    val title: String,
    val actors: List<Int>,
    val vote_average: Float,
    val overview: String,
    val release_date: String
)