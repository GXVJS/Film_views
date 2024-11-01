package com.example.film_views

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KomediActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_komedi)

        val titles = resources.getStringArray(R.array.movie_titles1)
        val descriptions = resources.getStringArray(R.array.movie_descriptions1)
        val images = listOf(R.drawable.movie4, R.drawable.movie5, R.drawable.movie6)
        val price = resources.getStringArray(R.array.count)

        val movies = titles.indices.map { index ->
            Movie(titles[index], descriptions[index], images[index], price[index])
        }

        val listView = findViewById<ListView>(R.id.listview1)
        listView.adapter = MovieAdapter(this, movies)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}