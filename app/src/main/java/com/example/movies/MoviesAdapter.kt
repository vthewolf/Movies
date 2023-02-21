package com.example.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.databinding.ViewMovieItemBinding
class MoviesAdapter(private val movies: List<Movie>, private val movieClickedListener: (Movie) -> Unit)
    : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Aqui va a crear una nueva vista cuando el Recycler se lo pida
        val binding = ViewMovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Actualiza una vista cuando el adapter se lo pida. Porque haya pasado por el adapter o
        // se esté reciclando una vista.
        val movie = movies[position]
        holder.bind(movies[position])
        holder.itemView.setOnClickListener{ movieClickedListener(movie)}
    }

    override fun getItemCount(): Int {
        // Devuelve el numero de elementos que tiene el adapter
        return movies.size
    }



    class ViewHolder(private val binding: ViewMovieItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            binding.title.text = movie.title
            Glide.with(binding.root.context)
                .load(movie.cover)
                .into(binding.cover)
        }
    }
}