package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionNulo
import java.time.LocalDateTime

data class Pelicula(
    val id: Int,
    var lenguaje: String?,
    var titulo: String?,
    var imagenUrl: String?,
    var votacion: Float?,
    var fechaLanzamiento: String?,
    var descripcion: String?,
    var diaRegistro: Int = LocalDateTime.now().dayOfWeek.value,
) {
    init {
        if (validacionNulo()) throw ExcepcionNulo()
    }

    //  todo val validacionArgumentos : ArrayList<String?> = arrayListOf( original_language, original_title,poster_path,release_date,overview)

    private fun validacionNulo(): Boolean =
        votacion == null || lenguaje.isNullOrEmpty() || titulo.isNullOrEmpty() ||
                imagenUrl.isNullOrEmpty() || fechaLanzamiento.isNullOrEmpty() ||
                descripcion.isNullOrEmpty()

}