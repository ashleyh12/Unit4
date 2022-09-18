package com.example.unit3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val context: Context, private val movies: MutableList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }


    override fun getItemCount() = movies.size
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        fun bind(movie: Movie){

        }
    }

}
