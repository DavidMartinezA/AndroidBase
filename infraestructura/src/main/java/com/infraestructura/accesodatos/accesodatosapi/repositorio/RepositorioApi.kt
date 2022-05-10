package com.infraestructura.accesodatos.accesodatosapi.repositorio

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.infraestructura.accesodatos.accesodatosapi.servicioapi.ServicioApi
import com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion.TraductorPagina
import com.infraestructura.accesodatos.accesodatoslocal.basedatos.BaseDatosPaginaPeliculas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class RepositorioApi @Inject constructor(
    private val baseDatosPaginaPeliculas: BaseDatosPaginaPeliculas,
    private val servicioApi: ServicioApi,
) {

    private val dispatchers = Dispatchers.IO
    private val traductor = TraductorPagina()

    suspend fun obtenerPaginaPeliculas(): PaginadoPeliculas = withContext(this.dispatchers) {
        val paginaPeliculas = baseDatosPaginaPeliculas.paginaPeliculasdao().obtener()
        if (paginaPeliculas.resultadoPeliculas.isNullOrEmpty()) {// todo  condicionar que actualice api cada 24 horas
            //Log.i("repos","Api Data")
            val servicioApiPagina = servicioApi.obtenerpagina()
            baseDatosPaginaPeliculas.paginaPeliculasdao().insertar(traductor.desdeDominioABaseDatos(servicioApiPagina))
            return@withContext servicioApiPagina
        } else {
            //Log.i("repos","Local Data")
            return@withContext traductor.desdeBaseDatosADominio(paginaPeliculas)
        }
    }
}