package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionCamposVacios
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test


class PeliculaTest {

    private var id: Int = 1
    private var idioma: String = "español"
    private var titulo: String = "Encanto"
    private var imagenUrl: String = "url"
    private var calificacion: Float = 8.55F
    private var fechaLanzamiento: String = "2022"
    private var descripcion: String = "pelicula colombiana"


    @Test
    fun init_validacionIdimaParametroCorrecto_idiomaPeliculas() {

        //Arrange
        //Act
        val pelicula = Pelicula(idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)

        //Assert
        assertEquals(pelicula.lenguaje, idioma)
    }

    @Test
    fun init_validacionTituloParametroCorrecto_tituloPeliculas() {

        //Arrange
        //Act
        val pelicula = Pelicula(idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)

        //Assert
        assertEquals(pelicula.titulo, titulo)
    }

    @Test
    fun init_validacionImagenUrlParametroCorrecto_imagenUrlPeliculas() {

        //Arrange
        //Act
        val pelicula = Pelicula(idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)

        //Assert
        assertEquals(pelicula.imagenUrl, imagenUrl)

    }

    @Test
    fun init_validacionCalificacionParametroCorrecto_calificacionPeliculas() {

        //Arrange
        //Act
        val pelicula = Pelicula(idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)

        //Assert
        assertEquals(pelicula.votacion, calificacion)
    }

    @Test
    fun init_validacionFechaLanzamientoParametroCorrecto_fechaLanzamientoPeliculas() {

        //Arrange
        //Act
        val pelicula = Pelicula(idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)

        //Assert
        assertEquals(pelicula.fechaLanzamiento, fechaLanzamiento)
    }

    @Test
    fun init_validacionDescripcionParametroCorrecto_descripcionPeliculas() {

        //Arrange
        //Act
        val pelicula = Pelicula(idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)

        //Assert
        assertEquals(pelicula.descripcion, descripcion)
    }

    @Test
    fun init_validacionoParametroIdiomaNulo_lanzarExcepcion() {

        //Arrange
        idioma = ""
        //Act
        //Assert
        assertThrows(ExcepcionCamposVacios::class.java) {
            Pelicula(idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun init_validacionParametroImagenUrlNulo_lanzarExcepcion() {

        //Arrange
        imagenUrl = ""
        //Act
        //Assert
        assertThrows(ExcepcionCamposVacios::class.java) {
            Pelicula(idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun init_validacionParametroFechaLanzamiento_lanzarExcepcion() {

        //Arrange
        fechaLanzamiento = ""
        //Act
        //Assert
        assertThrows(ExcepcionCamposVacios::class.java) {
            Pelicula(idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun init_validacionParametroDescripcionNulo_lanzarExcepcion() {

        //Arrange
        descripcion = ""
        //Act
        //Assert
        assertThrows(ExcepcionCamposVacios::class.java) {
            Pelicula(idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }
}