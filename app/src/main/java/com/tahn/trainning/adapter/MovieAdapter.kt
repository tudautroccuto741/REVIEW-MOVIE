package com.tahn.trainning.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tahn.trainning.R
import com.tahn.trainning.model.Movie

class MovieAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var listMovies = arrayListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_row, parent, false)
        return MovieViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MovieViewHolder).bind(listMovies[position])
    }

    inner class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private var movieName = itemView.findViewById<TextView>(R.id.tvMovieName)
        private val imgPicture = itemView.findViewById<ImageView>(R.id.imgMoviePicture)

        fun bind(item : Movie){
            movieName.text = item.title
            Glide.with(context.applicationContext ?: return).load("https://image.tmdb.org/t/p/w500" + "${item.poster}")
                .into(imgPicture)
        }
    }

    fun addList(listMovie : ArrayList<Movie>){
        listMovies.clear()
        listMovies.addAll(listMovie)
        notifyDataSetChanged()
    }
}