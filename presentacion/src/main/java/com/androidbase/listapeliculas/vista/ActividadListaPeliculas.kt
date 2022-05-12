package com.androidbase.listapeliculas.vista

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidbase.databinding.ActividadListaPeliculasBinding
import com.androidbase.listapeliculas.adaptadorlistapeliculas.AdaptadorListaPeliculas
import com.androidbase.listapeliculas.viewmodel.ListaPeliculasViewModel
import com.dominio.peliculas.modelo.Pelicula
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ActividadListaPeliculas : AppCompatActivity() {

    private val listaPeliculasViewModel: ListaPeliculasViewModel by viewModels()
    private lateinit var binding: ActividadListaPeliculasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActividadListaPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mostrarListaPeliculas()
    }

    private fun iniciarRecyclerView(listaPeliculas: List<Pelicula>) {
        binding.listaPeliculasRecyclerview.layoutManager = LinearLayoutManager(this)
        val adaptador = AdaptadorListaPeliculas(listaPeliculas)
        binding.listaPeliculasRecyclerview.adapter = adaptador
    }

    private fun mostrarListaPeliculas() {
        listaPeliculasViewModel.mostrarListaPeliculas()
        lifecycleScope.launchWhenStarted {
            listaPeliculasViewModel.ListaPeliculas.collect {
                iniciarRecyclerView(it)
            }
        }
    }

}
