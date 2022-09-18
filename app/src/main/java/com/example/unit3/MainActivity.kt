package com.example.unit3

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONException

private const val now_playing = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed&language=en-US&page=1"
class MainActivity : AppCompatActivity() {


    private val movies = mutableListOf<Movie>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieAdapter = MovieAdapter(this, movies)


        val asyncClient = AsyncHttpClient()
        asyncClient.get(now_playing, object: JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int, headers: Headers?, response: String?, throwable: Throwable?
            ) {
                Log.e(TAG, "onFailure $statusCode")

            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                Log.i(TAG, "onSuccess: JSON data $json")
                try {


                    val jsonArray = json!!.jsonObject.getJSONArray("results")
                    movies.addAll(Movie.fromJsonArray(jsonArray))
                    Log.i(TAG, "List of Movies $movies ")
                } catch (e: JSONException) {
                    Log.e(TAG, "Encountered Exception $e")
                }

            }

        })

    }
}