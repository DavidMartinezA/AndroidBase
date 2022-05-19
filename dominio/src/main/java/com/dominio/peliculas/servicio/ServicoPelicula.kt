package com.dominio.peliculas.servicio

import com.dominio.peliculas.modelo.Pelicula
import com.dominio.peliculas.repositorio.RepositorioPelicula
import javax.inject.Inject

class ServicoPelicula @Inject constructor(private var repositorioPelicula: RepositorioPelicula) {

    suspend fun consultarPaginaPeliculas(): List<Pelicula> {
        return repositorioPelicula.obtenerPaginaPeliculas()
    }

    suspend fun guardarPaginaPeliculas(pelicula: Pelicula) {
        repositorioPelicula.guardarPaginaPeliculas(pelicula)
    }

}