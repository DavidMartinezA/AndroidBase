package com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.infraestructura.accesodatos.accesodatoslocal.entidadbasedatos.EntidadBaseDatosPelicula

class TraductorPagina {

    fun desdeDominioABaseDatos(paginadoPeliculas: PaginadoPeliculas): EntidadBaseDatosPelicula {
        return EntidadBaseDatosPelicula(
            pagina = paginadoPeliculas.pagina,
            resultadoPeliculas = paginadoPeliculas.resultadoPeliculas,
            paginasTotales = paginadoPeliculas.paginasTotales,
            resultadoTotal = paginadoPeliculas.resultadoTotal)
    }

    fun desdeBaseDatosADominio(entidadBaseDatosPelicula: EntidadBaseDatosPelicula): PaginadoPeliculas {
        return PaginadoPeliculas(entidadBaseDatosPelicula.pagina,
            entidadBaseDatosPelicula.resultadoPeliculas,
            entidadBaseDatosPelicula.paginasTotales,
            entidadBaseDatosPelicula.resultadoTotal)
    }

}