package com.example.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        //Инициализация переменной кнопки перехода
        val textureView: TextView = findViewById(R.id.activity_movie_details_back_button)

        textureView.setOnClickListener { moveToNextScreen() }
    }

    fun moveToNextScreen() {
        val intent = Intent(this, Movies::class.java)

        startActivity(intent)
    }
}
