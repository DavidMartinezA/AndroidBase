package com.infraestructura.accesodatos.accesodatosapi.anticorrupcion

import com.dominio.peliculas.modelo.Pelicula
import com.infraestructura.accesodatos.accesodatosapi.dto.ListaResultadosDto

class TraductorApi {

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