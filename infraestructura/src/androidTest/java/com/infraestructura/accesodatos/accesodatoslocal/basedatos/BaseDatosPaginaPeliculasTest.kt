package com.infraestructura.accesodatos.accesodatoslocal.basedatos

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.dominio.peliculas.modelo.Pelicula
import com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion.TraductorPagina
import com.infraestructura.accesodatos.accesodatoslocal.dao.PaginaPeliculasDao
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

    private lateinit var paginaPeliculasDao: PaginaPeliculasDao
    private lateinit var baseDatosPelicula: BaseDatosPaginaPeliculas
    private val pelicula: Pelicula = Pelicula(1, "español", "Encanto", "url", 8.55F, "2022", "pelicula colombiana")
    private var pagina = 1
    private var resultadoPeliculas: ArrayList<Pelicula> = ArrayList()
    private var paginasTotales = 100
    private var resultadoTotal = 1000
    private val paginado = PaginadoPeliculas(pagina, resultadoPeliculas, paginasTotales, resultadoTotal)

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
        paginaPeliculasDao = baseDatosPelicula.paginaPeliculasdao()
        val entidadBaseDatosPaginaPeliculas = TraductorPagina().desdeDominioABaseDatos(paginado)

        //Act
        runTest {
            paginaPeliculasDao.insertar(entidadBaseDatosPaginaPeliculas)

            //Assert
            assertEquals(resultadoPeliculas, paginaPeliculasDao.obtener().last().resultadoPeliculas!!)
            assertEquals(1, paginaPeliculasDao.obtener().last().resultadoPeliculas!!.size)
        }
    }

    @Test
    fun insertarPaginaPeliculasDao_guardarPaginaConInformacionVacia_paginaGuardada() {

        //Arrange
        paginaPeliculasDao = baseDatosPelicula.paginaPeliculasdao()
        val entidadBaseDatosPaginaPeliculas = TraductorPagina().desdeDominioABaseDatos(paginado)

        //Act
        runTest {
            paginaPeliculasDao.insertar(entidadBaseDatosPaginaPeliculas)

            //Assert
            assertEquals(resultadoPeliculas, paginaPeliculasDao.obtener().last().resultadoPeliculas)
        }
    }

    @Test
    fun obtenerPaginaPeliculasDao_consultarPaginaConInformacion_retornaPaginaConInformacion() {

        //Arrange
        resultadoPeliculas.add(pelicula)
        paginaPeliculasDao = baseDatosPelicula.paginaPeliculasdao()
        val entidadBaseDatosPaginaPeliculas = TraductorPagina().desdeDominioABaseDatos(paginado)

        //Act
        runTest {
            paginaPeliculasDao.insertar(entidadBaseDatosPaginaPeliculas)
            val respuesta = paginaPeliculasDao.obtener()

            //Assert
            assertFalse(respuesta.last().resultadoPeliculas!!.isEmpty())
        }
    }

    @Test
    fun obtenerPaginaPeliculasDao_consultarPaginaConInformacionVacia_retornaPaginaConInformacionVacia() {

        //Arrange
        paginaPeliculasDao = baseDatosPelicula.paginaPeliculasdao()
        val entidadBaseDatosPaginaPeliculas = TraductorPagina().desdeDominioABaseDatos(paginado)

        //Act
        runTest {
            paginaPeliculasDao.insertar(entidadBaseDatosPaginaPeliculas)
            val respuesta = paginaPeliculasDao.obtener()

            //Assert
            assertTrue(respuesta.last().resultadoPeliculas!!.isEmpty())
        }
    }

}