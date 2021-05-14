package com.example.movies.data

import android.content.Context
import com.example.movies.api.JsonParser

object getMovie {
    fun getMovieById(context: Context, id: Long): JsonMovieData {
        val oneMovieList = JsonParser(context).moviesData.filter { it.id == id }
        return oneMovieList[0]
    }
}