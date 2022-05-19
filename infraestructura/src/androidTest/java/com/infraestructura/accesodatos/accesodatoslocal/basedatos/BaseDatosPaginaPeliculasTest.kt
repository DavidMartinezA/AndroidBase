package com.infraestructura.accesodatos.accesodatoslocal.basedatos

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dominio.peliculas.modelo.Pelicula
import com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion.TraductorPagina
import com.infraestructura.accesodatos.accesodatoslocal.dao.PeliculasDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class BaseDatosPaginaPeliculasTest {

    private lateinit var peliculasDao: PeliculasDao
    private lateinit var baseDatosPelicula: BaseDatosPaginaPeliculas
    private val pelicula: Pelicula = Pelicula(1, "español", "Encanto", "url", 8.55F, "2022", "pelicula colombiana")
    private var resultadoPeliculas: ArrayList<Pelicula> = arrayListOf(pelicula)


    @Before
    fun crecionBaseDatos() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        baseDatosPelicula = Room.inMemoryDatabaseBuilder(
            context, BaseDatosPaginaPeliculas::class.java).build()
    }

    @After
    fun closeDb() {
        baseDatosPelicula.close()
    }

    @Test
    fun insertarPaginaPeliculasDao_guardarPaginaConInformacion_paginaGuardada() {

        //Arrange
        resultadoPeliculas.add(pelicula)
        peliculasDao = baseDatosPelicula.peliculasDao()
        val entidadBaseDatosPaginaPeliculas = TraductorPagina().desdeDominioABaseDatos(pelicula)

        //Act
        runTest {
            peliculasDao.insertar(entidadBaseDatosPaginaPeliculas)

            //Assert
            assertEquals(pelicula.titulo, peliculasDao.obtener().last().titulo)
        }
    }

    @Test
    fun insertarPaginaPeliculasDao_guardarPaginaConInformacionVacia_paginaGuardada() {

        //Arrange
        peliculasDao = baseDatosPelicula.peliculasDao()
        val entidadBaseDatosPaginaPeliculas = TraductorPagina().desdeDominioABaseDatos(pelicula)

        //Act
        runTest {
            peliculasDao.insertar(entidadBaseDatosPaginaPeliculas)

            //Assert
            assertEquals(pelicula.titulo, peliculasDao.obtener()[0].titulo)
        }
    }

    @Test
    fun obtenerPaginaPeliculasDao_consultarPaginaConInformacion_retornaPaginaConInformacion() {

        //Arrange
        resultadoPeliculas.add(pelicula)
        peliculasDao = baseDatosPelicula.peliculasDao()
        val entidadBaseDatosPaginaPeliculas = TraductorPagina().desdeDominioABaseDatos(pelicula)

        //Act
        runTest {
            peliculasDao.insertar(entidadBaseDatosPaginaPeliculas)
            val respuesta = peliculasDao.obtener()

            //Assert
            assertFalse(respuesta.isNullOrEmpty())
        }
    }

    @Test
    fun obtenerPaginaPeliculasDao_consultarPaginaConInformacionVacia_LanzarExcepcion() {

        //Arrange
        //Act
        //Assert
        assertThrows(Exception::class.java) {
            runTest {
                peliculasDao.obtener()
            }
        }
    }

}