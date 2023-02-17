package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.movies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hay que configurar el Adapter
        binding.recycler.adapter = MoviesAdapter(
            listOf(
                Movie("Title 1", "url 1"),
                Movie("Title 2", "url 2"),
                Movie("Title 3", "url 3"),
                Movie("Title 4", "url 4"),
                Movie("Title 5", "url 5"),
                Movie("Title 6", "url 6"),
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("Main Activity", "onDestroy")
    }
}