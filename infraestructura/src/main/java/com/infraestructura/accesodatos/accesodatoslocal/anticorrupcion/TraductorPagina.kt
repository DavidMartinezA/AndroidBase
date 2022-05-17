package com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.infraestructura.accesodatos.accesodatoslocal.entidadbasedatos.EntidadBaseDatosPelicula

class TraductorPagina {

    fun desdeDominioABaseDatos(paginadoPeliculas: PaginadoPeliculas): EntidadBaseDatosPelicula {
        return EntidadBaseDatosPelicula(
            pagina = paginadoPeliculas.page,
            resultadoPeliculas = paginadoPeliculas.results,
            paginasTotales = paginadoPeliculas.total_pages,
            resultadoTotal = paginadoPeliculas.total_results,
            diaRegistro = paginadoPeliculas.diaRegistro,
            id = paginadoPeliculas.id
        )
    }

    fun desdeBaseDatosADominio(listaEntidadBaseDatos: List<EntidadBaseDatosPelicula>): List<PaginadoPeliculas> {

        val listaDominio = ArrayList<PaginadoPeliculas>()
        listaEntidadBaseDatos.map {
            val paginaPeliculasDominio = PaginadoPeliculas(it.pagina,
                it.resultadoPeliculas,
                it.paginasTotales,
                it.resultadoTotal
            )
            paginaPeliculasDominio.id = it.id
            paginaPeliculasDominio.diaRegistro = it.diaRegistro
            listaDominio.add(paginaPeliculasDominio)
        }
        return listaDominio
    }

}