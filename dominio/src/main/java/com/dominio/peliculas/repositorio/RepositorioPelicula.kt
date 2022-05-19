package com.dominio.peliculas.repositorio

import com.dominio.peliculas.modelo.Pelicula

interface RepositorioPelicula {

    suspend fun guardarPaginaPeliculas(pelicula: Pelicula)

    suspend fun obtenerPaginaPeliculas(): List<Pelicula>

}