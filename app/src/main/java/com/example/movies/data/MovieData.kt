package com.example.movies.data

import androidx.annotation.StringRes

data class MovieData(
    @StringRes
    val name: Int,
    val picSrc: Int,
    val age: Int,
    val hasLike: Boolean,
    val rating: Float,
    val reviewsCnt: Int,
    @StringRes
    val genre: Int,
    val duration: Int
)
