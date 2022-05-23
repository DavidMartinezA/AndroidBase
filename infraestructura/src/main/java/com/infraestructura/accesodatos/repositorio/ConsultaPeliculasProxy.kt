package com.infraestructura.accesodatos.repositorio

import com.dominio.peliculas.modelo.Pelicula
import com.dominio.peliculas.repositorio.RepositorioPelicula
import com.infraestructura.accesodatos.excepcion.ExcepcionErrorConsultaInformacionPeliculas
import javax.inject.Inject

class ConsultaPeliculasProxy @Inject constructor(
    val repositorioConsultaPeliculas: RepositorioConsultaPeliculas,
) : RepositorioPelicula {

    override suspend fun guardarPaginaPeliculas(pelicula: Pelicula) {
        repositorioConsultaPeliculas.guardarPaginaPeliculas(pelicula)
    }

    override suspend fun obtenerPaginaPeliculas(): List<Pelicula> {
        val respuesta = repositorioConsultaPeliculas.obtenerPaginaPeliculas()
        return if (respuesta.isNullOrEmpty()) {
            throw ExcepcionErrorConsultaInformacionPeliculas()
        } else {
            respuesta
        }
    }

}