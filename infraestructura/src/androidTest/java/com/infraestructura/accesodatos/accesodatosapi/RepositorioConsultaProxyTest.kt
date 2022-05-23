package com.infraestructura.accesodatos.accesodatosapi

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dominio.peliculas.modelo.Pelicula
import com.infraestructura.accesodatos.accesodatosapi.servicioapi.ServicioApi
import com.infraestructura.accesodatos.accesodatoslocal.basedatos.BaseDatosPaginaPeliculas
import com.infraestructura.accesodatos.anticorrupcion.TraductorPelicula
import com.infraestructura.accesodatos.repositorio.ConsultaPeliculasProxy
import com.infraestructura.accesodatos.repositorio.RepositorioConsultaPeliculas
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStreamReader

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class RepositorioConsultaProxyTest {

    private lateinit var servicioFakeWeb: MockWebServer
    private lateinit var baseDatosEntidades: BaseDatosPaginaPeliculas
    private lateinit var consultaPeliculasProxy: ConsultaPeliculasProxy
    private lateinit var consultaPeliculas: RepositorioConsultaPeliculas
    private lateinit var servicioApi: ServicioApi
    private var pelicula = Pelicula("Es", "Encanto", "Url", 0.0F, "2022", "PELICULA COLOMBIANA")
    private var resultadoPeliculas: ArrayList<Pelicula> = arrayListOf(pelicula)


    @Before
    fun configuracionInicial() {
        servicioFakeWeb = MockWebServer()

        val context = ApplicationProvider.getApplicationContext<Context>()
        baseDatosEntidades = Room.inMemoryDatabaseBuilder(
            context, BaseDatosPaginaPeliculas::class.java)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(servicioFakeWeb.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val baseDatosPaginaPeliculas = baseDatosEntidades
        servicioApi = retrofit.create(ServicioApi::class.java)

        consultaPeliculas = RepositorioConsultaPeliculas(baseDatosPaginaPeliculas, servicioApi)
        consultaPeliculasProxy = ConsultaPeliculasProxy(consultaPeliculas)

    }

    @After
    fun configuracionFinal() {
        servicioFakeWeb.shutdown()
        baseDatosEntidades.close()
    }

    private fun leerJson(): String {
        val reader = InputStreamReader(this.javaClass.classLoader?.getResourceAsStream("RespuestaPagina.json"))
        val content = reader.readText()
        reader.close()
        return content
    }

    @Test
    fun obtenerPaginaPeliculasApi_respuestaPaginaJson_paginaActualUno() = runTest {

        //Arrange

        servicioFakeWeb.enqueue(MockResponse().setBody(leerJson()))

        //Act
        val respuesta = servicioApi.obtenerPagina().resultadoPeliculas

        //Assert
        assertFalse(respuesta.isNullOrEmpty())
    }

    @Test
    fun obtenerPaginaPeliculas_paginaPeliculaCorrecta_paginaPelicula() = runTest {

        //Arrange
        resultadoPeliculas.forEach { baseDatosEntidades.peliculasDao().insertar(TraductorPelicula().desdeDominioABaseDatos(it)) }
        //Act
        val respuesta = consultaPeliculasProxy.obtenerPaginaPeliculas()
        //Assert
        assertFalse(respuesta.isEmpty())
    }

    @Test
    fun obtenerPaginaPeliculas_paginaResultadosPeliculaVacia_lanzarExcepcion() = runTest {

        //Arrange
        //Act
        Assert.assertThrows(Exception::class.java) {
            runTest {
                consultaPeliculasProxy.obtenerPaginaPeliculas()
            }
        }
    }

}