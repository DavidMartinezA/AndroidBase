package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionNulo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class PaginadoPeliculasTest {

    private val pelicula: Pelicula = Pelicula(1, "español", "Encanto", "url",
        8.55F, "2022", "pelicula colombiana")
    private var pagina: Int? = 1
    private var resultadoPeliculas: ArrayList<Pelicula>? = ArrayList()
    private var paginasTotales: Int? = 100
    private var resultadoTotal: Int? = 1000

    @Test
    fun init_validacionDeNoNuloPaginaParametroCorrecto_paginaPeliculas() {

        //Arrange
        resultadoPeliculas?.add(pelicula)

        //Act
        val paginado = PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)

        //Assert
        assertEquals(paginado.page, pagina)
    }

    @Test
    fun init_validacionDeNoNuloResultadoPeliculasParametroCorrecto_resultadoPeliculas() {

        //Arrange
        resultadoPeliculas?.add(pelicula)

        //Act
        val paginado = PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)

        //Assert
        assertEquals(paginado.results, resultadoPeliculas)
    }

    @Test
    fun init_validacionDeNoNuloPaginasTotalesParametroCorrecto_paginasTotales() {

        //Arrange
        resultadoPeliculas?.add(pelicula)

        //Act
        val paginado = PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)

        //Assert
        assertEquals(paginado.total_pages, paginasTotales)
    }

    @Test
    fun init_validacionDeNoNuloResultadoTotalParametroCorrecto_paginasTotales() {

        //Arrange
        resultadoPeliculas?.add(pelicula)

        //Act
        val paginado = PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)

        //Assert
        assertEquals(paginado.total_results, resultadoTotal)
    }


    @Test
    fun init_validacionDeNuloParametroPaginaNulo_lanzarExcepcionNulo() {

        //Arrange
        resultadoPeliculas?.add(pelicula)
        pagina = null

        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)
        }
    }

    @Test
    fun init_validacionDeNuloParametroResultadoPeliculasNulo_lanzarExcepcionNulo() {

        //Arrange
        resultadoPeliculas = null

        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)
        }
    }

    @Test
    fun init_validacionDeNuloParametroTotalResultsNulo_lanzarExcepcionNulo() {

        //Arrange
        resultadoTotal = null

        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)
        }
    }

    @Test
    fun init_validacionDeNuloParametroPaginasTotalesNulo_lanzarExcepcionNulo() {

        //Arrange
        paginasTotales = null

        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)
        }
    }
}