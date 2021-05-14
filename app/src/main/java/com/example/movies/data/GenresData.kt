package com.example.movies.data

import android.content.Context
import com.example.movies.api.JsonParser

class GenresData(context: Context) {
    var genres: HashMap<Int, String> = hashMapOf()

    init {
        JsonParser(context).genresData.forEach { genres[it.id] = it.name }
    }

    fun getGenres(genresIds: List<Int>): String {
        var s = ""
        for (id in genresIds) {
            s = "${genres[id]}, $s"
        }
        s = s.substring(0, s.length - 2)
        return s
    }
}