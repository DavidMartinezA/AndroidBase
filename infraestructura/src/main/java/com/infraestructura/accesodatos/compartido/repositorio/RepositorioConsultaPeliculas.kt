package com.infraestructura.accesodatos.compartido.repositorio

import com.dominio.peliculas.modelo.Pelicula
import com.dominio.peliculas.repositorio.RepositorioPelicula
import com.infraestructura.accesodatos.accesodatosapi.excepcion.ExcepcionErrorRetrofit
import com.infraestructura.accesodatos.accesodatosapi.servicioapi.ServicioApi
import com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion.TraductorPagina
import com.infraestructura.accesodatos.accesodatoslocal.basedatos.BaseDatosPaginaPeliculas
import javax.inject.Inject

class RepositorioConsultaPeliculas @Inject constructor(
    baseDatosPaginaPeliculas: BaseDatosPaginaPeliculas,
    private val servicioApi: ServicioApi,
) : RepositorioPelicula {

    private val peliculasDao = baseDatosPaginaPeliculas.peliculasDao()
    private val traductorPagina = TraductorPagina()

    override suspend fun guardarPaginaPeliculas(pelicula: Pelicula) {
        val entidadPaginaPeliculas = traductorPagina.desdeDominioABaseDatos(pelicula)
        peliculasDao.insertar(entidadPaginaPeliculas)
    }

    override suspend fun obtenerPaginaPeliculas(): List<Pelicula> {
        return traductorPagina.desdeBaseDatosADominio(peliculasDao.obtener())
    }

    suspend fun obtenerPeliculasApi(): List<Pelicula> {
        val dto = servicioApi.obtenerPagina()
        return dto.resultadoPeliculas?.let { traductorPagina.desdeApiADominio(it) } ?: throw ExcepcionErrorRetrofit()
    }

}
