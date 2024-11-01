package com.example.film_views

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.ScrollView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Объявил переменные для перехода на новые активности
        val btnBoevik: Button = findViewById(R.id.spisokBoevik)
        val btnKomedii: Button = findViewById(R.id.spisokKomedii)
        val btnDrammi: Button = findViewById(R.id.spisokDrammi)
        //Переменные дял вывода на главную
        val btnSpisok: Button = findViewById(R.id.spisokTotal)
        val scroll: ScrollView = findViewById(R.id.scroller)
        //Изменение видимости элемента
        btnSpisok.setOnClickListener{
            scroll.visibility = if (scroll.visibility == View.VISIBLE){
                View.GONE
            } else View.VISIBLE
        }
        //Объявление переменной для всплывающей подсказки
        val btnDev: Button = findViewById(R.id.devinfo)
        //Вывод подсказки
        btnDev.setOnClickListener{
            val text = "Игнатушин Павел, ИСП-21"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration).show()

        }
        //Переходы на новые активности
        btnBoevik.setOnClickListener{
            val intent = Intent(this@MainActivity, boevikActivity::class.java)
            startActivity(intent)
        }
        btnKomedii.setOnClickListener{
            val intent = Intent(this@MainActivity, KomediActivity::class.java)
            startActivity(intent)
        }
        btnDrammi.setOnClickListener{
            val intent = Intent(this@MainActivity, DrammaActivity::class.java)
            startActivity(intent)
        }
//Вывод на главную
        val price = resources.getStringArray(R.array.count)
        // Данные для трех категорий
        val titlesCategory1 = resources.getStringArray(R.array.movie_titles)
        val descriptionsCategory1 = resources.getStringArray(R.array.movie_descriptions)
        val imagesCategory1 = listOf(R.drawable.movie1, R.drawable.movie2, R.drawable.movie3)

        val titlesCategory2 = resources.getStringArray(R.array.movie_titles1)
        val descriptionsCategory2 = resources.getStringArray(R.array.movie_descriptions1)
        val imagesCategory2 = listOf(R.drawable.movie4, R.drawable.movie5, R.drawable.movie6)

        val titlesCategory3 = resources.getStringArray(R.array.movie_titles2)
        val descriptionsCategory3 = resources.getStringArray(R.array.movie_descriptions2)
        val imagesCategory3 = listOf(R.drawable.movie7, R.drawable.movie8, R.drawable.movie9)

        // Преобразуем данные в объекты Movie
        val moviesCategory1 = titlesCategory1.indices.map { index ->
            Movie(titlesCategory1[index], descriptionsCategory1[index], imagesCategory1[index], price[index])
        }
        val moviesCategory2 = titlesCategory2.indices.map { index ->
            Movie(titlesCategory2[index], descriptionsCategory2[index], imagesCategory2[index], price[index])
        }
        val moviesCategory3 = titlesCategory3.indices.map { index ->
            Movie(titlesCategory3[index], descriptionsCategory3[index], imagesCategory3[index], price[index])
        }

        // Настраиваем адаптеры для каждого ListView
        findViewById<ListView>(R.id.listViewCategory1).adapter = MovieAdapter(this, moviesCategory1)
        findViewById<ListView>(R.id.listViewCategory2).adapter = MovieAdapter(this, moviesCategory2)
        findViewById<ListView>(R.id.listViewCategory3).adapter = MovieAdapter(this, moviesCategory3)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}