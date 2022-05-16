package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionNulo
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class PaginadoPeliculas(

    @SerializedName("page") var pagina: Int?,
    @SerializedName("results") var resultadoPeliculas: List<Pelicula>?,
    @SerializedName("total_pages") var paginasTotales: Int?,
    @SerializedName("total_results") var resultadoTotal: Int?,
    var diaRegistro: Int = 1,
) {

    init {
        if (validacionNulo()) throw ExcepcionNulo()
        diaRegistro = LocalDateTime.now().dayOfWeek.value
    }

    private fun validacionNulo(): Boolean = pagina == null || resultadoPeliculas == null ||
            paginasTotales == null || resultadoTotal == null
}