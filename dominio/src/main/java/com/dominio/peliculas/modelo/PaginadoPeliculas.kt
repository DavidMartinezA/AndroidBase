package com.dominio.peliculas.modelo

data class PaginadoPeliculas(
    val page: Int?,
    val results: ArrayList<Pelicula>?,
    val total_pages: Int?,
    val total_results: Int?,
) {
}