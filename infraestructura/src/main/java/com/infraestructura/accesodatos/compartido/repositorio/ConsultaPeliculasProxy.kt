package com.infraestructura.accesodatos.compartido.repositorio

import com.dominio.peliculas.modelo.Pelicula
import com.dominio.peliculas.repositorio.RepositorioPelicula
import com.infraestructura.accesodatos.accesodatosapi.servicioapi.ServicioApi
import com.infraestructura.accesodatos.accesodatoslocal.basedatos.BaseDatosPaginaPeliculas
import javax.inject.Inject

class ConsultaPeliculasProxy @Inject constructor(
    val baseDatosPaginaPeliculas: BaseDatosPaginaPeliculas,
    servicioApi: ServicioApi,
) : RepositorioPelicula {

    private val repositorioConsultaPeliculas = RepositorioConsultaPeliculas(baseDatosPaginaPeliculas, servicioApi)
    private lateinit var respuesta: List<Pelicula>
    override suspend fun guardarPaginaPeliculas(pelicula: Pelicula) {
        repositorioConsultaPeliculas.guardarPaginaPeliculas(pelicula)
    }

    override suspend fun obtenerPaginaPeliculas(): List<Pelicula> {
        /*   val diaHoy = LocalDateTime.now().dayOfWeek.value

              if (!repositorioConsultaPeliculas.obtenerPaginaPeliculas().isNullOrEmpty() ||
                  repositorioConsultaPeliculas.obtenerPaginaPeliculas().last().diaRegistro == diaHoy
              ) {
                  val paginaPeliculasRoom = repositorioConsultaPeliculas.obtenerPaginaPeliculas()
                  respuesta = paginaPeliculasRoom
              } else {
                  if (repositorioConsultaPeliculas.obtenerPeliculasApi().isNullOrEmpty()) {
                      throw ExcepcionErrorRetrofit()
                  } else {
                      val paginaPeliculasApi = repositorioConsultaPeliculas.obtenerPeliculasApi()
                      respuesta = paginaPeliculasApi
                      //baseDatosPaginaPeliculas.peliculasDao().borrar()
                      respuesta.forEach { guardarPaginaPeliculas(it) }
                  }
          }*/
        return repositorioConsultaPeliculas.obtenerPeliculasApi()
    }
}