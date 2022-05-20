package com.androidbase.listapeliculas.vista

import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.androidbase.listapeliculas.vista.actividadlistapeliculas.ActividadListaPeliculas
import com.androidbase.listapeliculas.vista.pageobject.ActividadListaPeliculasPageObject
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