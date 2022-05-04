package com.dominio.peliculas.modelo

data class Pelicula(

    val id: Int?,
    val original_language: String,
    val original_title: String,
    val poster_path: String,
    val vote_average: Float,
    val release_date: String,
    val adult: Boolean,
    val overview: String,
) {


}