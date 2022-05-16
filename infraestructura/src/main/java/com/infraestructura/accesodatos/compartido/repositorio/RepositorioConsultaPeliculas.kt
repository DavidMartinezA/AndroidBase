package com.infraestructura.accesodatos.compartido.repositorio

import com.dominio.peliculas.excepcion.ExcepcionNulo
import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.infraestructura.accesodatos.accesodatosapi.repositorio.RepositorioApi
import com.infraestructura.accesodatos.accesodatoslocal.repositorio.RepositorioPeliculasRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException
import java.time.LocalDateTime
import javax.inject.Inject


class RepositorioConsultaPeliculas @Inject constructor(
    private val repositorioPeliculasRoom: RepositorioPeliculasRoom,
    private val repositorioApi: RepositorioApi,
) {
    private val dispatchers = Dispatchers.IO

    suspend fun obtenerPaginaPeliculas(): List<PaginadoPeliculas> = withContext(this.dispatchers) {
        val paginaPeliculas = repositorioPeliculasRoom.obtenerPaginaPeliculas()
        val diaHoy = LocalDateTime.now().dayOfWeek.value
        val diaRegistroPelicula = paginaPeliculas.last()


        if (paginaPeliculas.isNullOrEmpty() || diaRegistroPelicula.diaRegistro != diaHoy) {
            try {
                val servicioApiPagina = repositorioApi.obtenerPaginaPeliculas()
                repositorioPeliculasRoom.guardarPaginaPeliculas(servicioApiPagina)
                return@withContext listOf(servicioApiPagina)
            } catch (excepcion: UnknownHostException) {
                throw ExcepcionNulo()
            }
        } else {
            return@withContext repositorioPeliculasRoom.obtenerPaginaPeliculas()
        }
    }
}