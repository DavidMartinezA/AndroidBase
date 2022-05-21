package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionCamposVacios
import org.junit.Assert.*
import org.junit.Test


class PeliculaTest {

    @Test
    fun init_validacionIdParametroCorrecto_idPelicula() {

        //Arrange
        val pelicula = ConstructorPeliculasPruebas()
            .build()
        //Act
        //Assert
        assertEquals(0, pelicula.id)

    }

    @Test
    fun init_validacionLenguajeParametroCorrecto_lenguajePelicula() {

        //Arrange
        val pelicula = ConstructorPeliculasPruebas()
            .conLenguaje("Español")
            .build()
        //Act
        //Assert
        assertEquals("Español", pelicula.lenguaje)

    }

    @Test
    fun init_validacionTituloParametroCorrecto_tituloPelicula() {

        //Arrange
        //Act
        val pelicula = ConstructorPeliculasPruebas()
            .conTitulo("encanto")
            .build()

        //Assert
        assertEquals("encanto", pelicula.titulo)
    }

    @Test
    fun init_validacionImagenUrlParametroCorrecto_imagenUrlPelicula() {

        //Arrange
        //Act
        val pelicula = ConstructorPeliculasPruebas()
            .conImagen("Url de Imagen")
            .build()

        //Assert
        assertEquals("Url de Imagen", pelicula.imagenUrl)

    }

    @Test
    fun init_validacionVotacionParametroCorrecto_calificacionPelicula() {

        //Arrange
        //Act
        val pelicula = ConstructorPeliculasPruebas()
            .conVotacion(8.6F)
            .build()

        //Assert
        assertTrue(pelicula.votacion == 8.6F)
    }

    @Test
    fun init_validacionFechaLanzamientoParametroCorrecto_fechaLanzamientoPelicula() {

        //Arrange
        //Act
        val pelicula = ConstructorPeliculasPruebas()
            .conFechaLanzamiento("2022")
            .build()

        //Assert
        assertFalse(pelicula.fechaLanzamiento.isEmpty())
    }

    @Test
    fun init_validacionDescripcionParametroCorrecto_descripcionPelicula() {

        //Arrange
        //Act
        val pelicula = ConstructorPeliculasPruebas()
            .conDescripcion("Pelicula Colombiana")
            .build()

        //Assert
        assertSame("Pelicula Colombiana", pelicula.descripcion)
    }

    @Test
    fun init_validacionoParametroLenguajeVacio_lanzarExcepcion() {

        //Arrange
        //Act
        //Assert
        assertThrows(ExcepcionCamposVacios::class.java) {
            ConstructorPeliculasPruebas()
                .conLenguaje("")
                .build()
        }
    }

    @Test
    fun init_validacionParametroImagenUrlVacio_lanzarExcepcion() {

        //Arrange
        //Act
        //Assert
        assertThrows(ExcepcionCamposVacios::class.java) {
            ConstructorPeliculasPruebas()
                .conImagen("")
                .build()
        }
    }


    @Test
    fun init_validacionParametroFechaLanzamientoVacia_lanzarExcepcion() {

        //Arrange
        //Act
        //Assert
        assertThrows(ExcepcionCamposVacios::class.java) {
            ConstructorPeliculasPruebas()
                .conFechaLanzamiento("")
                .build()
        }
    }

    @Test
    fun init_validacionParametroDescripcionVacia_lanzarExcepcion() {

        //Arrange
        //Act
        //Assert
        assertThrows(ExcepcionCamposVacios::class.java) {
            ConstructorPeliculasPruebas()
                .conDescripcion("")
                .build()
        }
    }

}