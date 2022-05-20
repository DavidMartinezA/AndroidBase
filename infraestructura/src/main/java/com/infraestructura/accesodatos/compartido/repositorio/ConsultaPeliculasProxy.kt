package com.infraestructura.accesodatos.compartido.repositorio

import com.dominio.peliculas.modelo.Pelicula
import com.dominio.peliculas.repositorio.RepositorioPelicula
import com.infraestructura.accesodatos.accesodatosapi.excepcion.ExcepcionErrorRetrofit
import javax.inject.Inject

class ConsultaPeliculasProxy @Inject constructor(
    val repositorioConsultaPeliculas: RepositorioConsultaPeliculas,
) : RepositorioPelicula {

    override suspend fun guardarPaginaPeliculas(pelicula: Pelicula) {
        repositorioConsultaPeliculas.guardarPaginaPeliculas(pelicula)
    }

    override suspend fun obtenerPaginaPeliculas(): List<Pelicula> {
        return if (repositorioConsultaPeliculas.obtenerPaginaPeliculas().isNullOrEmpty()) {
            throw ExcepcionErrorRetrofit()
        } else {
            repositorioConsultaPeliculas.obtenerPaginaPeliculas()
        }
    }

}