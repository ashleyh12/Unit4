package com.example.unit3

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONException


//source(s) used: https://www.youtube.com/watch?v=mPlcAkuiH5M&list=PLrT2tZ9JRrf4wZSRwvvl-0eYqLCsP0_7q&ab_channel=CodePath

private const val now_playing = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed&language=en-US&page=1"
class MainActivity : AppCompatActivity() {


    private val movies = mutableListOf<Movie>()
    private lateinit var rvMovies: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMovies = findViewById(R.id.rvMovies)


        val movieAdapter = MovieAdapter(this, movies)

        rvMovies.adapter = movieAdapter
        rvMovies.layoutManager = LinearLayoutManager(this)

        val asyncClient = AsyncHttpClient()
        asyncClient.get(now_playing, object: JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int, headers: Headers?, response: String?, throwable: Throwable?
            ) {
                Log.e(newTag, "onFailure $statusCode")

            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                Log.i(newTag, "onSuccess: JSON data $json")
                try {


                    val jsonArray = json!!.jsonObject.getJSONArray("results")
                    movies.addAll(Movie.fromJsonArray(jsonArray))
                    movieAdapter.notifyDataSetChanged()
                    Log.i(newTag, "List of Movies $movies ")
                } catch (e: JSONException) {
                    Log.e(newTag, "Encountered Exception $e")
                }

            }

        })

    }
}
