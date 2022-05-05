package com.dominio.peliculas.servicio

import com.dominio.peliculas.modelo.Pelicula
import com.dominio.peliculas.repositorio.RepositorioPelicula

class ServicoPelicula(private var repositorioPelicula: RepositorioPelicula) {

    fun consultarListaPeliculas(): List<Pelicula> {
        return repositorioPelicula.listaPeliculas()
    }

    fun guardarListaPeliculas(listaPelicula: List<Pelicula>) {
        repositorioPelicula.guardarListaPeliculas(listaPelicula)
    }

    fun peliculaPorId(id: Int): Pelicula {
        return repositorioPelicula.peliculaPorId(id)
    }
}