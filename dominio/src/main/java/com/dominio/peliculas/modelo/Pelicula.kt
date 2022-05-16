package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionNulo

data class Pelicula(
    val id: Int?,
    var original_language: String?,
    var original_title: String?,
    var poster_path: String?,
    var vote_average: Float?,
    var release_date: String?,
    var overview: String?,
) {
    init {
        if (validacionNulo()) throw ExcepcionNulo()
    }

    val validacionArgumentos: ArrayList<String?> = arrayListOf(original_language, original_title, poster_path,
        vote_average.toString(), release_date, overview)

    private fun validacionNulo(): Boolean = validacionArgumentos.isNullOrEmpty()

}