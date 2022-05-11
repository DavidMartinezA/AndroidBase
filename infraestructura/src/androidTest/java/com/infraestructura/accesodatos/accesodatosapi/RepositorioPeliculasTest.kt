package com.infraestructura.accesodatos.accesodatosapi

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.dominio.peliculas.modelo.Pelicula
import com.infraestructura.accesodatos.accesodatosapi.repositorio.RepositorioApi
import com.infraestructura.accesodatos.accesodatosapi.repositorio.RepositorioPeliculas
import com.infraestructura.accesodatos.accesodatosapi.servicioapi.ServicioApi
import com.infraestructura.accesodatos.accesodatoslocal.anticorrupcion.TraductorPagina
import com.infraestructura.accesodatos.accesodatoslocal.basedatos.BaseDatosPaginaPeliculas
import com.infraestructura.accesodatos.accesodatoslocal.repositorio.RepositorioPeliculasRoom
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStreamReader

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class RepositorioPeliculasTest {

    private lateinit var servicioMockWeb: MockWebServer
    private lateinit var repositorioPeliculas: RepositorioPeliculas
    private lateinit var baseDatosEntidades: BaseDatosPaginaPeliculas
    private lateinit var repositorioApi: RepositorioApi
    private val pelicula: Pelicula = Pelicula(1, "español", "Encanto", "url", 8.55F, "2022", "pelicula colombiana")
    private var resultadoPeliculas: ArrayList<Pelicula> = ArrayList()
    private val paginado = PaginadoPeliculas(pagina = 1, resultadoPeliculas, paginasTotales = 100, resultadoTotal = 1000)

    @Before
    fun configuracionInicial() {
        servicioMockWeb = MockWebServer()

        val context = ApplicationProvider.getApplicationContext<Context>()
        baseDatosEntidades = Room.inMemoryDatabaseBuilder(
            context, BaseDatosPaginaPeliculas::class.java)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(servicioMockWeb.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val repositorioRoom = RepositorioPeliculasRoom(baseDatosEntidades)
        val servicioApi = retrofit.create(ServicioApi::class.java)
        repositorioApi = RepositorioApi(servicioApi)

        repositorioPeliculas = RepositorioPeliculas(repositorioRoom, repositorioApi)
    }

    @After
    fun configuracionFinal() {
        servicioMockWeb.shutdown()
        baseDatosEntidades.close()
    }

    private fun leerJson(path: String): String {
        val reader = InputStreamReader(this.javaClass.classLoader?.getResourceAsStream(path))
        val content = reader.readText()
        reader.close()
        return content
    }

    @Test
    fun obtenerPaginaPeliculas_paginaPeliculaCorrecta_paginaPelicula() = runTest {

        //Arrange
        resultadoPeliculas.add(pelicula)
        baseDatosEntidades.paginaPeliculasdao().insertar(TraductorPagina().desdeDominioABaseDatos(paginado))
        //Act
        val respuesta = repositorioPeliculas.obtenerPaginaPeliculas()
        //Assert
        assertFalse(respuesta.resultadoPeliculas!!.isEmpty())
    }

    @Test
    fun obtenerPaginaPeliculas_paginaResultadosPeliculaVacia_paginaresultadosPeliculaVacia() = runTest {

        //Arrange
        baseDatosEntidades.paginaPeliculasdao().insertar(TraductorPagina().desdeDominioABaseDatos(paginado))

        //Act
        val respuesta = repositorioPeliculas.obtenerPaginaPeliculas()

        //Assert
        assertTrue(respuesta.resultadoPeliculas!!.isEmpty())
    }

    @Test
    fun obtenerPaginaPeliculasApi_respuestaPaginaJson_paginaActualUno() = runTest {

        //Arrange
        val respuestaApi = leerJson("RespuestaPagina.json")
        servicioMockWeb.enqueue(MockResponse().setBody(respuestaApi))

        //Act
        val respuesta = repositorioApi.obtenerPaginaPeliculas()

        //Assert
        assertEquals(respuesta.pagina, 1)
    }

}