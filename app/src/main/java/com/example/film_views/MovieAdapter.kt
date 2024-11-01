package com.example.film_views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.film_views.R  // Импортируйте R для доступа к ресурсам
import com.example.film_views.Movie  // Импортируйте модель Movie

class MovieAdapter(private val context: Context, private val movies: List<Movie>) : BaseAdapter() {

    override fun getCount(): Int = movies.size

    override fun getItem(position: Int): Any = movies[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        val movie = movies[position]

        val imageView = view.findViewById<ImageView>(R.id.movieImage)
        val titleView = view.findViewById<TextView>(R.id.movieTitle)
        val descriptionView = view.findViewById<TextView>(R.id.movieDescription)
        val price = view.findViewById<TextView>(R.id.moviePrice)

        imageView.setImageResource(movie.imageResId)
        titleView.text = movie.title
        descriptionView.text = movie.description
        price.text = movie.price

        return view
    }
}