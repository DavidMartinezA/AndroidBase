package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionNulo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class PeliculaTest {

    var id: Int? = 1
    var idioma: String? = "español"
    var titulo: String? = "Encanto"
    var imagenUrl: String? = "url"
    var calificacion: Float? = 8.55F
    var fechaLanzamiento: String? = "2022"
    var descripcion: String? = "pelicula colombiana"


    @Test
    fun initValidacionDeNulo_parametrosCorrectos_paginadoPeliculasPage() {

        //Arrange
        //Act
        val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)

        //Assert
        assertEquals(pelicula.id, id)
        assertEquals(pelicula.idioma, idioma)
        assertEquals(pelicula.titulo, titulo)
        assertEquals(pelicula.imagenUrl, imagenUrl)
        assertEquals(pelicula.calificacion, calificacion)
        assertEquals(pelicula.fechaLanzamiento, fechaLanzamiento)
        assertEquals(pelicula.descripcion, descripcion)
    }

    @Test
    fun initValidacionDeNulo_parametroIdNulo_LanzarExcepcionNulo() {

        //Arrange
        id = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroOriginalLenguajeNulo_LanzarExcepcionNulo() {

        //Arrange
        idioma = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroOriginalTitleNulo_LanzarExcepcionNulo() {

        //Arrange
        titulo = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroPosterPathNulo_LanzarExcepcionNulo() {

        //Arrange
        imagenUrl = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroVoteAverageNulo_LanzarExcepcionNulo() {

        //Arrange
        calificacion = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroReleaseDateNulo_LanzarExcepcionNulo() {

        //Arrange
        fechaLanzamiento = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun initValidacionDeNulo_parametroOverviewNulo_LanzarExcepcionNulo() {

        //Arrange
        descripcion = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }
}