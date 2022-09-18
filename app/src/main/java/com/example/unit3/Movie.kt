package com.example.unit3

import org.json.JSONArray

data class Movie(
    val movieID: Int,
    private val poster: String,
    val title: String,
    val description: String,


) {
    val overview: CharSequence?
        get() {
            TODO()
        }
    val posterURL = "https://image.tmdb.org/t/p/w500/$poster"
    companion object {
        fun fromJsonArray(jsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until jsonArray.length()) {
                val movieJSON = jsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJSON.getInt("id"),
                        movieJSON.getString("poster"),
                        movieJSON.getString("title"),
                        movieJSON.getString("description"),
                    )
                )
            }
            return movies
        }
    }
}