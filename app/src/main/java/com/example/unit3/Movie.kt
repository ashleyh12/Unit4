package com.example.unit3

import android.os.Parcelable
import androidx.versionedparcelable.ParcelImpl
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import org.json.JSONArray

@Parcelize

//source(s) used: https://www.youtube.com/watch?v=mPlcAkuiH5M&list=PLrT2tZ9JRrf4wZSRwvvl-0eYqLCsP0_7q&ab_channel=CodePath

data class Movie(
    val movieID: Int,
    private val poster: String,
    val title: String,
    val description: String,


) : Parcelable {
    @IgnoredOnParcel
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
