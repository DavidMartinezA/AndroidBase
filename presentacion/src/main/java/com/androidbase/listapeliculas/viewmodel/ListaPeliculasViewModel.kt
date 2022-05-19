package com.androidbase.listapeliculas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dominio.peliculas.modelo.Pelicula
import com.infraestructura.accesodatos.compartido.repositorio.ConsultaPeliculasProxy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListaPeliculasViewModel @Inject constructor(private val repositorioConsulta: ConsultaPeliculasProxy) : ViewModel() {

    private val cambioUi: MutableStateFlow<List<Pelicula>> = MutableStateFlow(emptyList())
    var listaPeliculas: StateFlow<List<Pelicula>> = cambioUi
    private val listaUi: MutableStateFlow<Boolean> = MutableStateFlow(false)
    var listavacia: StateFlow<Boolean> = listaUi

    fun mostrarListaPeliculas() = viewModelScope.launch {
        val lista = repositorioConsulta.obtenerPaginaPeliculas()
        cambioUi.value = lista
        /*    try {
                val lista = repositorioConsulta.obtenerPaginaPeliculas()
                cambioUi.value = lista
            } catch (excepcion: Exception) {
                listaUi.value = true
            }*/
    }

}