package com.infraestructura.accesodatos.compartido.repositorio

import com.dominio.peliculas.modelo.Pelicula
import com.dominio.peliculas.repositorio.RepositorioPelicula
import com.infraestructura.accesodatos.accesodatosapi.excepcion.ExcepcionErrorRetrofit
import com.infraestructura.accesodatos.accesodatosapi.servicioapi.ServicioApi
import com.infraestructura.accesodatos.accesodatoslocal.basedatos.BaseDatosPaginaPeliculas
import java.time.LocalDateTime
import javax.inject.Inject

class ConsultaPeliculasProxy @Inject constructor(
    baseDatosPaginaPeliculas: BaseDatosPaginaPeliculas,
    servicioApi: ServicioApi,
) : RepositorioPelicula {

    private val repositorioConsultaPeliculas = RepositorioConsultaPeliculas(baseDatosPaginaPeliculas, servicioApi)
    override suspend fun guardarPaginaPeliculas(pelicula: Pelicula) {
        repositorioConsultaPeliculas.guardarPaginaPeliculas(pelicula)
    }

    override suspend fun obtenerPaginaPeliculas(): List<Pelicula> {
        val diaHoy = LocalDateTime.now().dayOfWeek.value

        return if (repositorioConsultaPeliculas.obtenerPaginaPeliculas().isNotEmpty() &&
            repositorioConsultaPeliculas.obtenerPaginaPeliculas().first().diaRegistro == diaHoy
        ) {
            repositorioConsultaPeliculas.obtenerPaginaPeliculas()
        } else {
            if (repositorioConsultaPeliculas.obtenerPeliculasApi().isNullOrEmpty()) {
                throw ExcepcionErrorRetrofit()
            } else {
                val paginaPeliculasApi = repositorioConsultaPeliculas.obtenerPeliculasApi()
                paginaPeliculasApi.forEach { guardarPaginaPeliculas(it) }

                repositorioConsultaPeliculas.obtenerPaginaPeliculas()
            }
        }

    }
}