package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionNulo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class PaginadoPeliculasTest {

    private val pelicula: Pelicula = Pelicula(1, "español", "Encanto", "url", 8.55F, "2022", "pelicula colombiana")
    private var pagina: Int? = 1
    private var resultadoPeliculas: ArrayList<Pelicula>? = ArrayList()
    private var paginasTotales: Int? = 100
    private var resultadoTotal: Int? = 1000

    @Test
    fun initValidacionDeNulo_parametrosCorrectos_paginadoPeliculasPage() {

        //Arrange
        resultadoPeliculas?.add(pelicula)

        //Act
        val paginado = PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)

        //Assert
        assertEquals(paginado.pagina, pagina)
        assertEquals(paginado.resultadoPeliculas, resultadoPeliculas)
        assertEquals(paginado.paginasTotales, paginasTotales)
        assertEquals(paginado.resultadoTotal, resultadoTotal)
    }

    @Test
    fun initValidacionDeNulo_parametroPageNulo_lanzarExcepcionNulo() {

        //Arrange
        resultadoPeliculas?.add(pelicula)
        pagina = null

        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val paginado = PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroResultsNulo_lanzarExcepcionNulo() {

        //Arrange
        resultadoPeliculas = null

        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val paginado = PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroTotalResultsNulo_lanzarExcepcionNulo() {

        //Arrange
        resultadoTotal = null

        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val paginado = PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroTotalPagesNulo_lanzarExcepcionNulo() {

        //Arrange
        paginasTotales = null

        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val paginado = PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)
        }
    }
}