package com.androidbase.detallepeliculas.pageobject

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.androidbase.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

open class ActividadListaPeliculasDetallePageObject {

    fun clickBotonVerDetalle(): ActividadListaPeliculasDetallePageObject {
        Espresso.onView(
            Matchers.allOf(ViewMatchers.withId(R.id.btn_ver_detalle), withText("Ver"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.listaPeliculasRecyclerview),
                        0),
                    7)))
            .perform(ViewActions.scrollTo(), ViewActions.click())
        return this

    }

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


    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int,
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}