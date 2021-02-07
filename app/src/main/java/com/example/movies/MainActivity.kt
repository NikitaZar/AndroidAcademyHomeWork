package com.example.movies

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Инициализация переменной кнопки перехода
        val textureView: TextView = findViewById(R.id.activity_movie_details)

        textureView.setOnClickListener{moveToNextScreen()}
        }
    fun moveToNextScreen(){
        val intent = Intent(this, MovieDetailsActivity::class.java)

        startActivity(intent)
    }

    }



