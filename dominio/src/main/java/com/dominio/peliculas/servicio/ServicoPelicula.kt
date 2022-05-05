package com.dominio.peliculas.servicio

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.dominio.peliculas.repositorio.RepositorioPelicula

class ServicoPelicula(private var repositorioPelicula: RepositorioPelicula) {

    suspend fun consultarPaginaPeliculas(): PaginadoPeliculas {
        return repositorioPelicula.obtenerPaginaPeliculas()
    }

    suspend fun guardarPaginaPeliculas(paginaPelicula: PaginadoPeliculas) {
        repositorioPelicula.guardarPaginaPeliculas(paginaPelicula)
    }

}