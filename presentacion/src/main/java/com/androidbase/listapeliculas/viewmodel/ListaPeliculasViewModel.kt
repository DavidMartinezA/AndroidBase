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
    var listaPeliculas: StateFlow<List<Pelicula>> = cambioUi
    private val listaUi: MutableStateFlow<Boolean> = MutableStateFlow(false)
    var listavacia: StateFlow<Boolean> = listaUi

    fun mostrarListaPeliculas() = viewModelScope.launch {

    try {
            val lista = repositorioConsulta.obtenerPaginaPeliculas().last().resultadoPeliculas
            if (!lista.isNullOrEmpty()) {
                cambioUi.value = lista
            } else {
                listaUi.value = true
            }
        } catch (excepcion: ExcepcionNulo) {
            listaUi.value = true
        }
    }

}