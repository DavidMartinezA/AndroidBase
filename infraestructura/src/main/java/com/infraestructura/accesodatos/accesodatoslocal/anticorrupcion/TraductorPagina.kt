package com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.infraestructura.accesodatos.accesodatoslocal.entidadbasedatos.EntidadBaseDatosPelicula

class TraductorPagina {

    fun desdeDominioABaseDatos(paginadoPeliculas: PaginadoPeliculas): EntidadBaseDatosPelicula {
        return EntidadBaseDatosPelicula(
            pagina = paginadoPeliculas.pagina,
            resultadoPeliculas = paginadoPeliculas.resultadoPeliculas,
            paginasTotales = paginadoPeliculas.paginasTotales,
            resultadoTotal = paginadoPeliculas.resultadoTotal,
            diaRegistro = paginadoPeliculas.diaRegistro)
    }

    fun desdeBaseDatosADominio(listaEntidadBaseDatos: List<EntidadBaseDatosPelicula>): List<PaginadoPeliculas> {

        val listaDominio = ArrayList<PaginadoPeliculas>()
        listaEntidadBaseDatos.map {
            val paginaPeliculasDominio = PaginadoPeliculas(it.pagina,
                it.resultadoPeliculas,
                it.paginasTotales,
                it.resultadoTotal,
                it.diaRegistro)

            listaDominio.add(paginaPeliculasDominio)
        }
        return listaDominio
    }

}