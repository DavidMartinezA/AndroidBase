package com.androidbase.listapeliculas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dominio.peliculas.excepcion.ExcepcionNulo
import com.dominio.peliculas.modelo.Pelicula
import com.infraestructura.accesodatos.compartido.repositorio.RepositorioConsultaPeliculas
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class ListaPeliculasViewModel @Inject constructor(private val repositorioConsulta: RepositorioConsultaPeliculas) : ViewModel() {

    private val cambioUi: MutableStateFlow<List<Pelicula>> = MutableStateFlow(emptyList())
    var ListaPeliculas: StateFlow<List<Pelicula>> = cambioUi

    fun mostrarListaPeliculas() = viewModelScope.launch {
        val lista = repositorioConsulta.obtenerPaginaPeliculas().last().resultadoPeliculas
        if (!lista.isNullOrEmpty()) {
            cambioUi.value = lista
        } else {
            throw ExcepcionNulo()
        }

    }


}