package com.androidbase.detallepeliculas.vista


import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.androidbase.actividadlistapeliculas.vista.ActividadListaPeliculas
import com.androidbase.detallepeliculas.pageobject.ActividadListaPeliculasDetallePageObject
import org.junit.Rule
import org.junit.Test

class ActividadDetallePeliculaTest {

    @Rule
    @JvmField

    var mActivityTestRule = ActivityScenarioRule(ActividadListaPeliculas::class.java)
    private val actividadListaPeliculasDetallePageObjectPageObject = ActividadListaPeliculasDetallePageObject()

    @Test
    fun mostrarListaPeliculas_parametrosCorrectos_ListaPeliculas() {

        //Given
        mActivityTestRule.scenario

        //When
        actividadListaPeliculasDetallePageObjectPageObject
            .clickBotonVerDetalle()

        //Then
        actividadListaPeliculasDetallePageObjectPageObject
            .existeTituloPelicula()
            .existeCartelPelicula()
            .existeTituloIdioma()
            .existeTituloVotacion()
            .existeFechaLanzamientoPelicula()
            .existeSipnosisPelicula()

        mActivityTestRule.scenario.close()
    }


}