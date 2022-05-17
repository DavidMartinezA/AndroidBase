package com.androidbase.actividaddetallepeliculas.vista


import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.androidbase.actividaddetallepeliculas.pageobject.ActividadListaPeliculasDetallePageObject
import com.androidbase.actividadlistapeliculas.vista.ActividadListaPeliculas
import com.androidbase.actividadlistapeliculas.vista.pageobject.ActividadListaPeliculasPageObject
import org.junit.Rule
import org.junit.Test

class ActividadDetallePeliculaTest {

    @Rule
    @JvmField

    var mActivityTestRule = ActivityScenarioRule(ActividadListaPeliculas::class.java)
    private val actividadListaPeliculasDetallePageObject = ActividadListaPeliculasDetallePageObject()
    private val actividadListaPeliculasPageObject = ActividadListaPeliculasPageObject()

    @Test
    fun mostrarListaPeliculas_parametrosCorrectos_ListaPeliculas() {

        //Given
        mActivityTestRule.scenario

        //When
        actividadListaPeliculasPageObject
            .clickBotonVerDetalles()

        //Then
        actividadListaPeliculasDetallePageObject
            .existeTituloPelicula()
            .existeCartelPelicula()
            .existeTituloIdioma()
            .existeTituloVotacion()
            .existeFechaLanzamientoPelicula()
            .existeSipnosisPelicula()

        mActivityTestRule.scenario.close()
    }


}