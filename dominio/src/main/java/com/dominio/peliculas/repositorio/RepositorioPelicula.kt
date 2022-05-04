package com.dominio.peliculas.repositorio

import com.dominio.peliculas.modelo.Pelicula

interface RepositorioPelicula {

    fun peliculaPorId(id: Int): Pelicula

    fun guardarListaPeliculas(listaPeliculas: List<Pelicula>)

    fun listaPeliculas(): List<Pelicula>
}