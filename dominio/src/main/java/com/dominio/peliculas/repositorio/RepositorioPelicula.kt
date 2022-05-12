package com.dominio.peliculas.repositorio

import com.dominio.peliculas.modelo.PaginadoPeliculas

interface RepositorioPelicula {

    suspend fun guardarPaginaPeliculas(paginaPeliculas: PaginadoPeliculas)

    suspend fun obtenerPaginaPeliculas(): List<PaginadoPeliculas>

}