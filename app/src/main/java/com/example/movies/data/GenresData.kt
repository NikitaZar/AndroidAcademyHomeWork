package com.example.movies.data

class GenresData() {
    var genres: HashMap<Int, String> = hashMapOf()

    fun initGenres(jsonGenresData: Array<JsonGenresData>) {
        jsonGenresData.forEach { genres[it.id] = it.name }
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