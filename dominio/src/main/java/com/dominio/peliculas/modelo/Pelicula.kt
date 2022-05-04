package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionNulo

data class Pelicula(

    val id: Int?,
    val original_language: String?,
    val original_title: String?,
    val poster_path: String?,
    val vote_average: Float?,
    val release_date: String?,
    val overview: String?,
) {
    init {
        if (validacionNulo()) throw ExcepcionNulo()
    }

    private fun validacionNulo(): Boolean = id == null || original_language == null || original_title == null || poster_path == null
            || vote_average == null || release_date == null || overview == null

}