package com.dominio.peliculas.servicio

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.dominio.peliculas.modelo.Pelicula
import com.dominio.peliculas.repositorio.RepositorioPelicula
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class ServicoPeliculaTest {

    @Mock
    private lateinit var repositorioPeliculas: RepositorioPelicula

    private val pelicula: Pelicula = Pelicula(1, "español", "Encanto", "url",
        8.55F, "2022", "pelicula colombiana")
    private var pagina: Int? = 1
    private var resultadoPeliculas: ArrayList<Pelicula>? = arrayListOf(pelicula)
    private var paginasTotales: Int? = 100
    private var resultadoTotal: Int? = 1000
    private val paginado = PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun consultarPaginaPeliculas_parametrosCorrectos_retornaPaginaPeliculas() = runTest {

        //Arrange
        Mockito.`when`(repositorioPeliculas.obtenerPaginaPeliculas()).thenReturn(paginado)

        //Act
        val consultarPaginaPeliculas = ServicoPelicula(repositorioPeliculas).consultarPaginaPeliculas()

        //Assert
        assertEquals(consultarPaginaPeliculas, paginado)

    }

    @Test
    fun guardarPaginaPeliculas_paginaPeliculasCorrecta_paginaGuardada() = runTest {

        //Arrange
        //Act
        ServicoPelicula(repositorioPeliculas).guardarPaginaPeliculas(paginado)

        //Assert
        verify(repositorioPeliculas, times(1)).guardarPaginaPeliculas(paginado)
    }


}