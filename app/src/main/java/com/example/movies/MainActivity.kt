package com.example.movies

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.model.MovieDbClient
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hay que configurar el Adapter
        val moviesAdapter = MoviesAdapter(emptyList()) {movie ->
            Toast.makeText(this@MainActivity, movie.title, Toast.LENGTH_SHORT).show()
        }
        binding.recycler.adapter = moviesAdapter

        thread {
            val apiKey = getString(R.string.api_key)
            val popularMovies = MovieDbClient.service.listPopularMovies(apiKey)
            val body = popularMovies.execute().body()

            runOnUiThread{
                if (body != null)
                    moviesAdapter.movies = body.results
                    moviesAdapter.notifyDataSetChanged()
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("Main Activity", "onDestroy")
    }
}