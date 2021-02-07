package com.example.movies

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Инициализация переменной кнопки перехода
        val textureView: TextView = findViewById(R.id.activity_movie)

        textureView.setOnClickListener{moveToNextScreen()}
        }
    fun moveToNextScreen(){
        val intent = Intent(this, Movies::class.java)

        startActivity(intent)
    }

    }



