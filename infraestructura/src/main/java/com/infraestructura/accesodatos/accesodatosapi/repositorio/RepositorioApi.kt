package com.infraestructura.accesodatos.accesodatosapi.repositorio

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.infraestructura.accesodatos.accesodatosapi.servicioapi.ServicioApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class RepositorioApi @Inject constructor(
    private val servicioApi: ServicioApi,
) {

    private val dispatchers = Dispatchers.IO

    suspend fun obtenerPaginaPeliculas(): PaginadoPeliculas = withContext(this.dispatchers) {
        return@withContext servicioApi.obtenerpagina()

    }
}

