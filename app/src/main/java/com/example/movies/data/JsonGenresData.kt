package com.example.movies.data

import kotlinx.serialization.Serializable

@Serializable
data class JsonGenresData(
    val id: Int,
    val name: String
)