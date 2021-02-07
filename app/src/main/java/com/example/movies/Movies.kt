package com.example.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Movies : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        //Инициализация переменной кнопки перехода
        val textureView: TextView = findViewById(R.id.first_movie)

        textureView.setOnClickListener { moveToNextScreen() }
    }

    fun moveToNextScreen() {
        val intent = Intent(this, MovieDetailsActivity::class.java)

        startActivity(intent)
    }
}