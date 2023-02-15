package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.movies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*PARA EL VIEW BINDING HAY QUE DECLARAR ESTA VARIABLE
        * El ActivityMainBinding es el fruto del nombre del xml en camelCase + Binding
        * El binding representa todos los elementos que tenemos en el layout*/
        val binding = ActivityMainBinding.inflate(layoutInflater)

        /* Luego en el setContentView llamamos a binding.root. La raiz del componente
        * que hemos inflado */
        setContentView(binding.root)

        // ACCEDER A VISTAS CON VIEWBINDING
        binding.message.text = "Hello Android"
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("Main Activity", "onDestroy")
    }
}