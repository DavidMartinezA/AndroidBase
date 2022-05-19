package com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion

import com.dominio.peliculas.modelo.Pelicula
import com.infraestructura.accesodatos.accesodatosapi.dto.ListaResultadosDto
import com.infraestructura.accesodatos.accesodatoslocal.entidadbasedatos.EntidadBaseDatosPelicula

class TraductorPagina {

    fun desdeDominioABaseDatos(pelicula: Pelicula): EntidadBaseDatosPelicula {
        return EntidadBaseDatosPelicula(
            id = pelicula.id,
            lenguaje = pelicula.lenguaje,
            titulo = pelicula.titulo,
            imagen = pelicula.imagenUrl,
            votacion = pelicula.votacion,
            descripcion = pelicula.descripcion,
            fechaLanzamiento = pelicula.fechaLanzamiento,
            diaRegistro = pelicula.diaRegistro
        )
    }

    fun desdeBaseDatosADominio(listaEntidadBaseDatos: List<EntidadBaseDatosPelicula>): List<Pelicula> {

        val listaDominio = ArrayList<Pelicula>()
        listaEntidadBaseDatos.map {
            val peliculaDominio = Pelicula(
                it.id,
                it.lenguaje,
                it.titulo,
                it.imagen,
                it.votacion,
                it.fechaLanzamiento,
                it.descripcion,
                it.diaRegistro
            )
            listaDominio.add(peliculaDominio)
        }
        return listaDominio
    }

    fun desdeApiADominio(listaApi: List<ListaResultadosDto>): List<Pelicula> {

        val listaDominio = ArrayList<Pelicula>()
        listaApi.map {
            val peliculaDominio = Pelicula(
                id = 0,
                it.lenguaje,
                it.titulo,
                it.imagenUrl,
                it.votacion,
                it.fechaLanzamiento,
                it.descripcion,
                diaRegistro = 0
            )
            listaDominio.add(peliculaDominio)
        }
        return listaDominio
    }

}