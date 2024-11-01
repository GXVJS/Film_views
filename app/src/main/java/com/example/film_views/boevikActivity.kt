package com.example.film_views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ListView


class boevikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boevik)

        val titles = resources.getStringArray(R.array.movie_titles)
        val descriptions = resources.getStringArray(R.array.movie_descriptions)
        val price = resources.getStringArray(R.array.count)
        val images = listOf(R.drawable.movie1, R.drawable.movie2, R.drawable.movie3)

        val movies = titles.indices.map { index ->
            Movie(titles[index], descriptions[index], images[index], price[index])
        }

        val listView = findViewById<ListView>(R.id.listview)
        listView.adapter = MovieAdapter(this, movies)

    }
}