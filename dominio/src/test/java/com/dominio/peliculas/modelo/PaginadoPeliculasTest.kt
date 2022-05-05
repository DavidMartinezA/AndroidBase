package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionNulo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class PaginadoPeliculasTest {

    private val pelicula: Pelicula = Pelicula(1, "español", "Encanto", "url", 8.55F, "2022", "pelicula colombiana")
    private var page: Int? = 1
    private var results: ArrayList<Pelicula>? = ArrayList()
    private var total_pages: Int? = 100
    private var total_results: Int? = 1000

    @Test
    fun initValidacionDeNulo_parametrosCorrectos_paginadoPeliculasPage() {

        //Arrange
        results?.add(pelicula)

        //Act
        val paginado = PaginadoPeliculas(page, results, total_pages, total_results)

        //Assert
        assertEquals(paginado.page, page)
        assertEquals(paginado.results, results)
        assertEquals(paginado.total_pages, total_pages)
        assertEquals(paginado.total_results, total_results)
    }

    @Test
    fun initValidacionDeNulo_parametroPageNulo_lanzarExcepcionNulo() {

        //Arrange
        results?.add(pelicula)
        page = null

        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val paginado = PaginadoPeliculas(page, results, total_pages, total_results)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroResultsNulo_lanzarExcepcionNulo() {

        //Arrange
        results = null

        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val paginado = PaginadoPeliculas(page, results, total_pages, total_results)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroTotalResultsNulo_lanzarExcepcionNulo() {

        //Arrange
        total_results = null

        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val paginado = PaginadoPeliculas(page, results, total_pages, total_results)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroTotalPagesNulo_lanzarExcepcionNulo() {

        //Arrange
        total_pages = null

        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val paginado = PaginadoPeliculas(page, results, total_pages, total_results)
        }
    }
}