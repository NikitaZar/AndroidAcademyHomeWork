package com.example.movies.api

import android.content.Context
import android.util.Log
import com.example.movies.data.JsonActorData
import com.example.movies.data.JsonGenresData
import com.example.movies.data.JsonMovieData
import com.example.movies.data.MovieData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.IOException

class JsonParser(context: Context) {
    lateinit var jsonString: String

    var moviesData = Json.decodeFromString<List<JsonMovieData>>(jsonToString(context, "data.json"))
    var genresData = Json.decodeFromString<Array<JsonGenresData>>(jsonToString(context, "genres.json"))
    var actorsData = Json.decodeFromString<Array<JsonActorData>>(jsonToString(context, "people.json"))

    private fun jsonToString(context: Context, fileName: String): String {
        var jsonToString: String = ""
        try {
            jsonToString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
        return jsonToString
    }
}