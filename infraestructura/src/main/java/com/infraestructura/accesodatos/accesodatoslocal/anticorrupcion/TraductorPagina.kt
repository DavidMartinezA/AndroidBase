package com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion

import com.dominio.peliculas.modelo.Pelicula
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

                it.lenguaje,
                it.titulo,
                it.imagen,
                it.votacion,
                it.fechaLanzamiento,
                it.descripcion,

                )
            it.id
            it.diaRegistro
            listaDominio.add(peliculaDominio)
        }
        return listaDominio
    }

}