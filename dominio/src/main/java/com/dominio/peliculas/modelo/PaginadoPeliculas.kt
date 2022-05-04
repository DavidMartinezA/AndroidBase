package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionNulo

data class PaginadoPeliculas(
    val page: Int?,
    val results: ArrayList<Pelicula>?,
    val total_pages: Int?,
    val total_results: Int?,
) {

    init {
        if (validacionNulo()) throw ExcepcionNulo()
    }

    private fun validacionNulo(): Boolean = page == null || results == null || total_pages == null || total_results == null

}