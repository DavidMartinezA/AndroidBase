package com.dominio.peliculas.servicio

import com.dominio.peliculas.modelo.Pelicula
import com.dominio.peliculas.repositorio.RepositorioPelicula
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
    private val listaPeliculas: ArrayList<Pelicula> = arrayListOf(pelicula)

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun consultarListaPeliculas_parametrosCorrectos_retornaListaUsuarios() {

        //Arrange
        Mockito.`when`(repositorioPeliculas.listaPeliculas()).thenReturn(listaPeliculas)

        //Act
        val consultaDeListaPeliculas = ServicoPelicula(repositorioPeliculas).consultarListaPeliculas()

        //Assert
        assertEquals(consultaDeListaPeliculas, listaPeliculas)

    }

    @Test
    fun consultarListaPeliculas_listaVacia_retornaListaUsuariosVacia() {

        //Arrange
        val listaPeliculasDos: ArrayList<Pelicula> = arrayListOf()
        Mockito.`when`(repositorioPeliculas.listaPeliculas()).thenReturn(listaPeliculasDos)

        //Act
        val consultaDeListaPeliculas = ServicoPelicula(repositorioPeliculas).consultarListaPeliculas()

        //Assert
        assertEquals(consultaDeListaPeliculas, listaPeliculasDos)

    }

    @Test
    fun guardarListaPeliculas_listaPeliculasCorrecta_listaGuardada() {

        //Arrange
        //Act
        ServicoPelicula(repositorioPeliculas).guardarListaPeliculas(listaPeliculas)

        //Assert
        verify(repositorioPeliculas, times(1)).guardarListaPeliculas(listaPeliculas)
    }

    @Test
    fun guardarListaPeliculas_listaPeliculasVacia_listaGuardada() {

        //Arrange
        val listaPeliculasTres: ArrayList<Pelicula> = arrayListOf()
        //Act
        ServicoPelicula(repositorioPeliculas).guardarListaPeliculas(listaPeliculasTres)

        //Assert
        verify(repositorioPeliculas, times(1)).guardarListaPeliculas(listaPeliculasTres)
    }


    @Test
    fun peliculaPorId_idCorrecto_usuarioPorId() {

        //Arrange
        Mockito.`when`(repositorioPeliculas.peliculaPorId(1)).thenReturn(pelicula)

        //Act
        val peliculaPorId = ServicoPelicula(repositorioPeliculas).peliculaPorId(1)

        //Assert
        assertEquals(peliculaPorId, pelicula)
    }
}