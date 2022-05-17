package com.androidbase.actividadlistapeliculas.vista

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidbase.R
import com.androidbase.actividadlistapeliculas.adaptadorlistapeliculas.AdaptadorListaPeliculas
import com.androidbase.actividadlistapeliculas.viewmodel.ListaPeliculasViewModel
import com.androidbase.databinding.ActividadListaPeliculasBinding
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

        lifecycleScope.launch {
            listaPeliculasViewModel.listavacia.collect {
                if (it) {
                    val dialogoExcepciones = AlertDialog.Builder(this@ActividadListaPeliculas)
                    dialogoExcepciones.setTitle(getString(R.string.app_name))
                    dialogoExcepciones.setMessage("No Existe Informacion En La Lista")
                        .setPositiveButton(getString(R.string.boton_aceptar), null)
                        .show()
                }
            }
        }
    }


}