package com.infraestructura.accesodatos.compartido.repositorio

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.dominio.peliculas.repositorio.RepositorioPelicula
import com.infraestructura.accesodatos.accesodatosapi.servicioapi.ServicioApi
import com.infraestructura.accesodatos.accesodatoslocal.basedatos.BaseDatosPaginaPeliculas
import java.time.LocalDateTime
import javax.inject.Inject

class ConsultaPeliculasProxy @Inject constructor(
    baseDatosPaginaPeliculas: BaseDatosPaginaPeliculas,
    servicioApi: ServicioApi,
) : RepositorioPelicula {

    private val repositorioConsultaPeliculas = RepositorioConsultaPeliculas(baseDatosPaginaPeliculas, servicioApi)

    override suspend fun guardarPaginaPeliculas(paginaPeliculas: PaginadoPeliculas) {
        repositorioConsultaPeliculas.guardarPaginaPeliculas(paginaPeliculas)
    }

    override suspend fun obtenerPaginaPeliculas(): List<PaginadoPeliculas> {

        val paginaPeliculasRoom = repositorioConsultaPeliculas.obtenerPaginaPeliculas()
        val paginaPeliculasApi = repositorioConsultaPeliculas.obtenerPeliculasApi()
        val diaHoy = LocalDateTime.now().dayOfWeek.value

        return if (paginaPeliculasRoom.isNullOrEmpty() || paginaPeliculasRoom.last().diaRegistro != diaHoy) {
            repositorioConsultaPeliculas.guardarPaginaPeliculas(paginaPeliculasApi)
            listOf(paginaPeliculasApi)
        } else {
            paginaPeliculasRoom
        }
    }
}