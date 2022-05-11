package com.infraestructura.accesodatos.accesodatosapi.repositorio

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.infraestructura.accesodatos.accesodatoslocal.repositorio.RepositorioPeliculasRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import javax.inject.Inject


class RepositorioPeliculas @Inject constructor(
    private val repositorioPeliculasRoom: RepositorioPeliculasRoom,
    private val repositorioApi: RepositorioApi,
) {

    private val dispatchers = Dispatchers.IO

    suspend fun obtenerPaginaPeliculas(): PaginadoPeliculas = withContext(this.dispatchers) {

        val paginaPeliculas = repositorioPeliculasRoom.obtenerPaginaPeliculas()
        if (paginaPeliculas.diaRegistro != LocalDateTime.now().dayOfWeek.value) {
            //Log.i("repos","Api Data")
            val servicioApiPagina = repositorioApi.obtenerPaginaPeliculas()
            repositorioPeliculasRoom.guardarPaginaPeliculas(servicioApiPagina)
            return@withContext servicioApiPagina
        } else {
            //Log.i("repos","Local Data")
            return@withContext paginaPeliculas
        }
    }
}