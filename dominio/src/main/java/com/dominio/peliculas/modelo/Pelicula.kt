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
    init {
        if (validacionVacio()) throw ExcepcionCamposVacios()
    }

    var id = 0
    var diaRegistro: Int = LocalDateTime.now().dayOfWeek.value

    //val  validacionVacios = arrayListOf(id,lenguaje,titulo,imagenUrl,votacion,fechaLanzamiento,descripcion,diaRegistro)

    private fun validacionVacio() = lenguaje.isEmpty() || imagenUrl.isEmpty() || votacion.toString().isEmpty()
            || fechaLanzamiento.isEmpty() || descripcion.isEmpty()

}