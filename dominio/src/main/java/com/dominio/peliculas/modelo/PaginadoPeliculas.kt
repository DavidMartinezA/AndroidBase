package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionNulo
import java.time.LocalDateTime

data class PaginadoPeliculas(
    var page: Int?,
    var results: List<Pelicula>?,
    var total_pages: Int?,
    var total_results: Int?,
    var diaRegistro: Int = LocalDateTime.now().dayOfWeek.value,
    var id: Int = 0,
) {

    init {
        if (validacionNulo()) throw ExcepcionNulo()
    }

    //private val validacionArgumentos: ArrayList<Int?> = arrayListOf( page,total_pages,total_results)

    private fun validacionNulo(): Boolean = page == null || results.isNullOrEmpty() ||
            total_pages == null || total_results == null

}