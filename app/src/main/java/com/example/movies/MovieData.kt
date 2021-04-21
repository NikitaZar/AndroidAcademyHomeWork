package com.example.movies

data class MovieData(
    var name: String,
    var picSrc: Int,
    var age: Int,
    var hasLike: Boolean,
    var rating: Float,
    var reviewsCnt: Int,
    var genre: String,
    var duration: Int
)