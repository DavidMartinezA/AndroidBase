package com.androidbase.listapeliculas.vista.actividadlistapeliculas

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidbase.R
import com.androidbase.databinding.ActividadListaPeliculasBinding
import com.androidbase.listapeliculas.adaptadorlistapeliculas.AdaptadorListaPeliculas
import com.androidbase.listapeliculas.viewmodel.ListaPeliculasViewModel
import com.dominio.peliculas.modelo.Pelicula
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ActividadListaPeliculas : AppCompatActivity() {

    private val listaPeliculasViewModel: ListaPeliculasViewModel by viewModels()
    private lateinit var binding: ActividadListaPeliculasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActividadListaPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mostrarListaPeliculas()
        generarSuscripcionDialogoExcepciones()
    }

    private fun iniciarRecyclerView(listaPeliculas: List<Pelicula>) {

        binding.listaPeliculasRecyclerview.layoutManager = LinearLayoutManager(this)
        val adaptador = AdaptadorListaPeliculas(listaPeliculas)
        binding.listaPeliculasRecyclerview.adapter = adaptador
    }

    private fun mostrarListaPeliculas() {

        listaPeliculasViewModel.mostrarListaPeliculas()
        lifecycleScope.launchWhenStarted {
            listaPeliculasViewModel.listaPeliculas.collect {
                iniciarRecyclerView(it)
            }
        }
    }

    private fun generarSuscripcionDialogoExcepciones() {

        lifecycleScope.launch {
            listaPeliculasViewModel.excepcionesGeneradas.collect {
                if (it.isNotEmpty()) {
                    val dialogoExcepciones = AlertDialog.Builder(this@ActividadListaPeliculas)
                    dialogoExcepciones.setTitle(getString(R.string.app_name))
                    dialogoExcepciones.setMessage(it)
                        .setPositiveButton(getString(R.string.boton_aceptar), null)
                        .show()
                }
            }
        }
    }
}