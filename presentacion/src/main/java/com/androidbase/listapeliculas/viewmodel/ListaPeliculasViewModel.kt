package com.androidbase.listapeliculas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dominio.peliculas.excepcion.ExcepcionCamposVacios
import com.dominio.peliculas.modelo.Pelicula
import com.infraestructura.accesodatos.excepcion.ExcepcionErrorConsultaInformacionPeliculas
import com.infraestructura.accesodatos.repositorio.ConsultaPeliculasProxy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListaPeliculasViewModel @Inject constructor(private val consultaPeliculas: ConsultaPeliculasProxy) : ViewModel() {

    private val cambioUi: MutableStateFlow<List<Pelicula>> = MutableStateFlow(emptyList())
    var listaPeliculas: StateFlow<List<Pelicula>> = cambioUi
    private val mensageExcepciones: MutableStateFlow<String> = MutableStateFlow("")
    var excepcionesGeneradas: StateFlow<String> = mensageExcepciones

    fun mostrarListaPeliculas() = viewModelScope.launch {

        try {
            val lista = consultaPeliculas.obtenerPaginaPeliculas()
            cambioUi.value = lista
        } catch (excepcion: ExcepcionCamposVacios) {
            excepcion.message.let { mensageExcepciones.value = it.toString() } // validar el if para mostrar mensaje aqui
        } catch (excepcion: ExcepcionErrorConsultaInformacionPeliculas) {
            excepcion.message.let { mensageExcepciones.value = it.toString() }
        } catch (excepcion: Exception) {
            mensageExcepciones.value = "Error No Es Posible Mostrar La Informacion"
        }
    }

}