package com.example.unit3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log



private const val TAG = "DetailActivity"
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie = intent.getParcelableExtra<Movie>(Movieextra) as Movie
        Log.i(TAG, "Movie is $movie")
    }
}