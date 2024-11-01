package com.example.film_views

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DrammaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dramma)
        val titles = resources.getStringArray(R.array.movie_titles2)
        val descriptions = resources.getStringArray(R.array.movie_descriptions2)
        val images = listOf(R.drawable.movie7, R.drawable.movie8, R.drawable.movie9)
        val price = resources.getStringArray(R.array.count)

        val movies = titles.indices.map { index ->
            Movie(titles[index], descriptions[index], images[index], price[index])
        }

        val listView = findViewById<ListView>(R.id.listview2)
        listView.adapter = MovieAdapter(this, movies)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}