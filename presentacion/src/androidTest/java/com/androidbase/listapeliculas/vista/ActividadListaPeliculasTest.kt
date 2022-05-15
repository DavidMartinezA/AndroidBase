package com.androidbase.listapeliculas.vista

import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import com.androidbase.R
import com.androidbase.actividadlistapeliculaspageobject.ActividadListaPeliculasPageObject
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ActividadListaPeliculasTest {

    @Rule
    @JvmField

    var mActivityTestRule = ActivityScenarioRule(ActividadListaPeliculas::class.java)
    private val actividadListaPeliculasPageObject = ActividadListaPeliculasPageObject()

    @Before
    fun borrarBaseDatos() {
        InstrumentationRegistry.getInstrumentation().targetContext.deleteDatabase(R.string.nombre_base_datos.toString())
    }

    @Before
    fun obtenerActividadDos() {
        Intents.init()
    }

    @After
    fun cerrarActividadDos() {
        Intents.release()
    }

    @Test
    fun mostrarListaPeliculas_parametrosCorrectos_ListaPeliculas() {

        //Given
        mActivityTestRule.scenario
        actividadListaPeliculasPageObject
            .existeTituloApp()
            .existeScrollView()
            .existeRecyclerView()
            .existeCartelPelicula()
            .existeTituloPelicula()
            .existeInfoTextoTituloPelicula()
            .existeTituloIdioma()
            .existeInfoTextoIdioma()
            .existeInfoTextoVotacion()
            .existeTituloVotacion()
            .existeBotonVerDetallePeliculas()

        //When
        actividadListaPeliculasPageObject
            .clickBotonVerDetalles()

        //Then
        actividadListaPeliculasPageObject.verificarLanzamientoActividadDetalle()
        mActivityTestRule.scenario.close()
    }

}