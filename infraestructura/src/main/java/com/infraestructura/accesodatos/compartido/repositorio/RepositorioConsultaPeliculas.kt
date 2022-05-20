package com.infraestructura.accesodatos.compartido.repositorio

import com.dominio.peliculas.modelo.Pelicula
import com.dominio.peliculas.repositorio.RepositorioPelicula
import com.infraestructura.accesodatos.accesodatosapi.anticorrupcion.TraductorApi
import com.infraestructura.accesodatos.accesodatosapi.servicioapi.ServicioApi
import com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion.TraductorPagina
import com.infraestructura.accesodatos.accesodatoslocal.basedatos.BaseDatosPaginaPeliculas
import java.time.LocalDateTime
import javax.inject.Inject

class RepositorioConsultaPeliculas @Inject constructor(
    baseDatosPaginaPeliculas: BaseDatosPaginaPeliculas,
    private val servicioApi: ServicioApi,
) : RepositorioPelicula {

    private val peliculasDao = baseDatosPaginaPeliculas.peliculasDao()
    private val traductorPagina = TraductorPagina()
    private val traductorApi = TraductorApi()

    override suspend fun guardarPaginaPeliculas(pelicula: Pelicula) {
        val entidadPaginaPeliculas = traductorPagina.desdeDominioABaseDatos(pelicula)
        peliculasDao.insertar(entidadPaginaPeliculas)
    }

    override suspend fun obtenerPaginaPeliculas(): List<Pelicula> {
        val diaHoy = LocalDateTime.now().dayOfWeek.value

        return if (peliculasDao.obtener().isNotEmpty() && peliculasDao.obtener().first().diaRegistro == diaHoy) {
            traductorPagina.desdeBaseDatosADominio(peliculasDao.obtener())
        } else {
            val peliculaApi = servicioApi.obtenerPagina().resultadoPeliculas
            if (peliculaApi.isNullOrEmpty() && peliculasDao.obtener().isNotEmpty()) {
                traductorPagina.desdeBaseDatosADominio(peliculasDao.obtener())
            }
            val paginaPeliculasApi = traductorApi.desdeApiADominio(peliculaApi)
            paginaPeliculasApi.forEach {
                guardarPaginaPeliculas(it)
            }
            traductorPagina.desdeBaseDatosADominio(peliculasDao.obtener())

        }
    }

}