package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionNulo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class PeliculaTest {

    var id: Int? = 1
    var original_language: String? = "español"
    var original_title: String? = "Encanto"
    var poster_path: String? = "url"
    var vote_average: Float? = 8.55F
    var release_date: String? = "2022"
    val overview: String? = "pelicula colombiana"


    @Test
    fun initValidacionDeNulo_parametrosCorrectos_paginadoPeliculasPage() {

        //Arrange
        //Act
        val pelicula = Pelicula(id, original_language, original_title, poster_path, vote_average, release_date, overview)

        //Assert
        assertEquals(pelicula.id, id)
        assertEquals(pelicula.original_language, original_language)
        assertEquals(pelicula.original_title, original_title)
        assertEquals(pelicula.poster_path, poster_path)
        assertEquals(pelicula.vote_average, vote_average)
        assertEquals(pelicula.release_date, release_date)
        assertEquals(pelicula.overview, overview)
    }

    @Test
    fun initValidacionDeNulo_parametroIdNulo_LanzarExcepcionNulo() {

        //Arrange
        id = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, original_language, original_title, poster_path, vote_average, release_date, overview)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroOriginalLenguajeNulo_LanzarExcepcionNulo() {

        //Arrange
        original_language = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, original_language, original_title, poster_path, vote_average, release_date, overview)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroOriginalTitleNulo_LanzarExcepcionNulo() {

        //Arrange
        original_title = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, original_language, original_title, poster_path, vote_average, release_date, overview)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroPosterPathNulo_LanzarExcepcionNulo() {

        //Arrange
        poster_path = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, original_language, original_title, poster_path, vote_average, release_date, overview)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroVoteAverageNulo_LanzarExcepcionNulo() {

        //Arrange
        vote_average = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, original_language, original_title, poster_path, vote_average, release_date, overview)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroReleaseDateNulo_LanzarExcepcionNulo() {

        //Arrange
        release_date = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, original_language, original_title, poster_path, vote_average, release_date, overview)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroOverviewNulo_LanzarExcepcionNulo() {

        //Arrange
        release_date = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, original_language, original_title, poster_path, vote_average, release_date, overview)
        }
    }
}