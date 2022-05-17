package com.infraestructura.accesodatos.compartido.repositorio

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.dominio.peliculas.repositorio.RepositorioPelicula
import com.infraestructura.accesodatos.accesodatosapi.servicioapi.ServicioApi
import com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion.TraductorPagina
import com.infraestructura.accesodatos.accesodatoslocal.basedatos.BaseDatosPaginaPeliculas
import java.time.LocalDateTime
import javax.inject.Inject

class RepositorioConsultaPeliculas @Inject constructor(
    baseDatosPaginaPeliculas: BaseDatosPaginaPeliculas,
    private val servicioApi: ServicioApi,
) : RepositorioPelicula {

    private val paginaPeliculasDao = baseDatosPaginaPeliculas.paginaPeliculasdao()
    private val traductorPagina = TraductorPagina()

    override suspend fun guardarPaginaPeliculas(paginaPeliculas: PaginadoPeliculas) {
        val entidadPaginaPeliculas = traductorPagina.desdeDominioABaseDatos(paginaPeliculas)
        paginaPeliculasDao.insertar(entidadPaginaPeliculas)
    }

    override suspend fun obtenerPaginaPeliculas(): List<PaginadoPeliculas> {

        val paginaPeliculas = paginaPeliculasDao.obtener()
        val diaHoy = LocalDateTime.now().dayOfWeek.value

        if (paginaPeliculas.isNullOrEmpty() || paginaPeliculas.last().diaRegistro != diaHoy) {
            paginaPeliculasDao.insertar(traductorPagina.desdeDominioABaseDatos(servicioApi.obtenerPagina()))
            return listOf(servicioApi.obtenerPagina())
        } else {
            return traductorPagina.desdeBaseDatosADominio(paginaPeliculas)
        }
    }
}
