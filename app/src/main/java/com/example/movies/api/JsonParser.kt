package com.example.movies.api

import android.content.Context
import com.example.movies.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class JsonParser() {

    private val json = Json

    private fun jsonToString(context: Context, fileName: String): String {
        var jsonToString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        return jsonToString
    }

    private suspend fun parseGenres(
        context: Context,
        fileName: String,
        ids: List<Int>
    ): List<String> = withContext(Dispatchers.IO) {
        val data =
            json.decodeFromString<List<JsonGenresData>>(jsonToString(context, fileName))
        val map = data.associateBy { it.id }
        ids.map { map[it]!!.name}
    }

    private suspend fun parseActors(
        context: Context,
        fileName: String,
        ids: List<Int>
    ): List<ActorData> = withContext(Dispatchers.IO) {
        val data =
            json.decodeFromString<List<JsonActorData>>(jsonToString(context, fileName))
        val actorMap = data.associateBy { it.id }
        ids.map {
            ActorData(
                name = actorMap[it]!!.name,
                profile_path = actorMap[it]!!.profile_path
            )
        }
    }

    suspend fun parseMovie(
        context: Context,
        dataFile: String,
        genresFile: String,
        actorsFile: String,
    ): List<MovieData> = withContext(Dispatchers.IO) {
        val movies =
            json.decodeFromString<List<JsonMovieData>>(jsonToString(context, dataFile))

        movies.map {
            (MovieData(
                name = it.title,
                posterPic = it.poster_path,
                backdropPic = it.backdrop_path,
                rating = it.vote_average / 2,
                reviews = it.vote_count,
                duration = it.runtime,
                overview = it.overview,
                age = if (it.adult) 16 else 13,
                hasLike = false,
                genres = parseGenres(context, genresFile, it.genre_ids),
                actors = parseActors(context, actorsFile, it.actors)
            ))
        }
    }
}