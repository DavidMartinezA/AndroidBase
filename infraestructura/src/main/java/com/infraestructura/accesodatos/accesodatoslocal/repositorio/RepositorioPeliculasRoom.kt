package com.infraestructura.accesodatos.accesodatoslocal.repositorio

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.dominio.peliculas.repositorio.RepositorioPelicula
import com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion.TraductorPagina
import com.infraestructura.accesodatos.accesodatoslocal.basedatos.BaseDatosPaginaPeliculas
import javax.inject.Inject

class RepositorioPeliculasRoom @Inject constructor(baseDatosPaginaPeliculas: BaseDatosPaginaPeliculas) : RepositorioPelicula {

    private val paginaPeliculasDao = baseDatosPaginaPeliculas.paginaPeliculasdao()
    private val traductorPagina = TraductorPagina()

    override suspend fun guardarPaginaPeliculas(paginaPeliculas: PaginadoPeliculas) {
        val entidadPaginaPeliculas = traductorPagina.desdeDominioABaseDatos(paginaPeliculas)
        paginaPeliculasDao.insertar(entidadPaginaPeliculas)
    }

    override suspend fun obtenerPaginaPeliculas(): List<PaginadoPeliculas> {
        return traductorPagina.desdeBaseDatosADominio(paginaPeliculasDao.obtener())
    }

}