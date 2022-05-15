package com.androidbase.actividadlistapeliculas.vista

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
        generarDialogoExcepciones()
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

    private fun generarDialogoExcepciones() {
        val dialogoExcepciones = AlertDialog.Builder(this)
        dialogoExcepciones.setTitle(getString(R.string.app_name))
        lifecycleScope.launch {
            listaPeliculasViewModel.listavacia.collect {
                if (it) {
                    dialogoExcepciones.setMessage("No Existe Informacion En La Lista")
                        .setPositiveButton(getString(R.string.boton_aceptar), null)
                        .show()
                }
            }
        }
    }

}