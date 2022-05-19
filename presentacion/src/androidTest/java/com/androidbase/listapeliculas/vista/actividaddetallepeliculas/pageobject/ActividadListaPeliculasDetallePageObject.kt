package com.androidbase.listapeliculas.vista.actividaddetallepeliculas.pageobject

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.androidbase.R
import org.hamcrest.Matchers

open class ActividadListaPeliculasDetallePageObject {

    fun existeCartelPelicula(): ActividadListaPeliculasDetallePageObject {
        Espresso.onView(
            Matchers.allOf(ViewMatchers.withId(R.id.cartelPeliculaDetalleImageView),
                ViewMatchers.withParent(ViewMatchers.withParent(ViewMatchers.withId(R.id.peliculaDetallesCardView))),
                isDisplayed()))
            .check(matches(isDisplayed()))
        return this
    }

    fun existeTituloPelicula(): ActividadListaPeliculasDetallePageObject {
        Espresso.onView(
            Matchers.allOf(ViewMatchers.withId(R.id.tituloPeliculaDetalleTextView), withText("Pelicula:"),
                ViewMatchers.withParent(ViewMatchers.withParent(ViewMatchers.withId(R.id.peliculaDetallesCardView))),
                isDisplayed()))
            .check(matches(withText("Pelicula:")))
        return this
    }

    fun existeTituloIdioma(): ActividadListaPeliculasDetallePageObject {
        Espresso.onView(
            Matchers.allOf(ViewMatchers.withId(R.id.tituloIdiomaDetalleTextView), withText("Idioma:"),
                ViewMatchers.withParent(ViewMatchers.withParent(ViewMatchers.withId(R.id.peliculaDetallesCardView))),
                isDisplayed()))
            .check(matches(withText("Idioma:")))
        return this
    }

    fun existeTituloVotacion(): ActividadListaPeliculasDetallePageObject {
        Espresso.onView(
            Matchers.allOf(ViewMatchers.withId(R.id.tituloVotacionDetalleTextView), withText("Votacion:"),
                ViewMatchers.withParent(ViewMatchers.withParent(ViewMatchers.withId(R.id.peliculaDetallesCardView))),
                isDisplayed()))
            .check(matches(withText("Votacion:")))
        return this
    }

    fun existeFechaLanzamientoPelicula(): ActividadListaPeliculasDetallePageObject {
        Espresso.onView(
            Matchers.allOf(ViewMatchers.withId(R.id.tituloFechaLanzamientoTextView), withText("Fecha de Lanzamiento:"),
                ViewMatchers.withParent(ViewMatchers.withParent(ViewMatchers.withId(R.id.peliculaInformacionDetallesCardView))),
                isDisplayed()))
            .check(matches(withText("Fecha de Lanzamiento:")))
        return this
    }

    fun existeSipnosisPelicula() {
        Espresso.onView(
            Matchers.allOf(ViewMatchers.withId(R.id.tituloSipnosisTextView), withText("Sipnosis:"),
                ViewMatchers.withParent(ViewMatchers.withParent(ViewMatchers.withId(R.id.peliculaInformacionDetallesCardView))),
                isDisplayed()))
            .check(matches(withText("Sipnosis:")))
    }

}