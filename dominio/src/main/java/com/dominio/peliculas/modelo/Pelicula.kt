package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionCamposVacios
import java.time.LocalDateTime

data class Pelicula(

    var lenguaje: String,
    var titulo: String,
    var imagenUrl: String,
    var votacion: Float,
    var fechaLanzamiento: String,
    var descripcion: String,

    ) {
    var id = 0
    var diaRegistro: Int = LocalDateTime.now().dayOfWeek.value

    val validacionVacios = arrayListOf(lenguaje, titulo, imagenUrl, votacion.toString(), fechaLanzamiento, descripcion)

    init {
        if (validacionVacio()) throw ExcepcionCamposVacios()
    }

    private fun validacionVacio() = validacionVacios.any { it.isEmpty() }

}