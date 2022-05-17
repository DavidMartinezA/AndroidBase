package com.infraestructura.accesodatos.compartido.repositorio

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.dominio.peliculas.repositorio.RepositorioPelicula
import com.infraestructura.accesodatos.accesodatosapi.servicioapi.ServicioApi
import com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion.TraductorPagina
import com.infraestructura.accesodatos.accesodatoslocal.basedatos.BaseDatosPaginaPeliculas
import javax.inject.Inject

class RepositorioConsultaPeliculas @Inject constructor(
    baseDatosPaginaPeliculas: BaseDatosPaginaPeliculas,
    servicioApi: ServicioApi,
) : RepositorioPelicula {

    private val paginaPeliculasDao = baseDatosPaginaPeliculas.paginaPeliculasdao()
    private val traductorPagina = TraductorPagina()
    private val servicioApi = servicioApi

    override suspend fun guardarPaginaPeliculas(paginaPeliculas: PaginadoPeliculas) {
        val entidadPaginaPeliculas = traductorPagina.desdeDominioABaseDatos(paginaPeliculas)
        paginaPeliculasDao.insertar(entidadPaginaPeliculas)
    }

    override suspend fun obtenerPaginaPeliculas(): List<PaginadoPeliculas> {
        return traductorPagina.desdeBaseDatosADominio(paginaPeliculasDao.obtener())
    }

    suspend fun obtenerPeliculasApi(): PaginadoPeliculas {
        return servicioApi.obtenerPagina()
    }
}
