package com.example.unit3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


//source(s) used: https://www.youtube.com/watch?v=mPlcAkuiH5M&list=PLrT2tZ9JRrf4wZSRwvvl-0eYqLCsP0_7q&ab_channel=CodePath
private const val TAG = "MovieAdapter"
class MovieAdapter(private val context: Context, private val movies: MutableList<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }


    override fun getItemCount() = movies.size
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val itemViewPoster = itemView.findViewById<ImageView>(R.id.itemViewPoster)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvOverview = itemView.findViewById<TextView>(R.id.tvOverview)


        init {
            itemView.setOnClickListener(this)
        }


        fun bind(movie: Movie){
            tvTitle.text = movie.title
            tvOverview.text = movie.description
            Glide.with(context).load(movie.posterURL).into(itemViewPoster)

        }

        override fun onClick(p0: View?) {
            //notifed of movie that was clicked
            val movie = movies[adapterPosition]
            Toast.makeText(context, movie.title, Toast.LENGTH_SHORT).show()
            //use the system to navigate to the new activity
        }
    }

}

