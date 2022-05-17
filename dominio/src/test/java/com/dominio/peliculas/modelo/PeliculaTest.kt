package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionNulo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class PeliculaTest {

    private var id: Int? = 1
    private var idioma: String? = "español"
    private var titulo: String? = "Encanto"
    private var imagenUrl: String? = "url"
    private var calificacion: Float? = 8.55F
    private var fechaLanzamiento: String? = "2022"
    private var descripcion: String? = "pelicula colombiana"


    @Test
    fun init_validacionDeNuloIdimaParametroCorrecto_idiomaPaginadoPeliculas() {

        //Arrange
        //Act
        val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)

        //Assert
        assertEquals(pelicula.original_language, idioma)
    }

    @Test
    fun init_validacionDeNuloTituloParametroCorrecto_tituloPaginadoPeliculas() {

        //Arrange
        //Act
        val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)

        //Assert
        assertEquals(pelicula.original_title, titulo)
    }

    @Test
    fun init_validacionDeNuloImagenUrlParametroCorrecto_imagenUrlPaginadoPeliculas() {

        //Arrange
        //Act
        val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)

        //Assert
        assertEquals(pelicula.poster_path, imagenUrl)

    }

    @Test
    fun init_validacionDeNuloCalificacionParametroCorrecto_calificacionPaginadoPeliculas() {

        //Arrange
        //Act
        val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)

        //Assert
        assertEquals(pelicula.vote_average, calificacion)
    }

    @Test
    fun init_validacionDeNuloFechaLanzamientoParametroCorrecto_fechaLanzamientoPaginadoPeliculas() {

        //Arrange
        //Act
        val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)

        //Assert
        assertEquals(pelicula.release_date, fechaLanzamiento)
    }

    @Test
    fun init_validacionDeNuloDescripcionParametroCorrecto_descripcionPaginadoPeliculas() {

        //Arrange
        //Act
        val pelicula = Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)

        //Assert
        assertEquals(pelicula.overview, descripcion)
    }

    @Test
    fun init_validacionDeNuloParametroIdiomaNulo_lanzarExcepcionNulo() {

        //Arrange
        idioma = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun init_validacionDeNuloParametroTituloNulo_lanzarExcepcionNulo() {

        //Arrange
        titulo = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun init_validacionDeNuloParametroImagenUrlNulo_lanzarExcepcionNulo() {

        //Arrange
        imagenUrl = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun init_validacionDeNuloParametroCalificacionNulo_lanzarExcepcionNulo() {

        //Arrange
        calificacion = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun init_validacionDeNuloParametroFechaLanzamiento_lanzarExcepcionNulo() {

        //Arrange
        fechaLanzamiento = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }

    @Test
    fun init_validacionDeNuloParametroDescripcionNulo_lanzarExcepcionNulo() {

        //Arrange
        descripcion = null
        //Act
        //Assert
        assertThrows(ExcepcionNulo::class.java) {
            Pelicula(id, idioma, titulo, imagenUrl, calificacion, fechaLanzamiento, descripcion)
        }
    }
}