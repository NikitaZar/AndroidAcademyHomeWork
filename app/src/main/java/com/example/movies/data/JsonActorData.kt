package com.example.movies.data

import kotlinx.serialization.Serializable

@Serializable
data class JsonActorData(
    val gender: Int,
    val id: Int,
    val name: String,
    val original_name: String,
    val profile_path: String
    )