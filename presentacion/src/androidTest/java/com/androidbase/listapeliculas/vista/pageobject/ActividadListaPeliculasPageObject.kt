package com.androidbase.listapeliculas.vista.pageobject

import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.androidbase.R
import com.androidbase.listapeliculas.vista.actividaddetallepeliculas.ActividadDetallePelicula
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf

open class ActividadListaPeliculasPageObject {

    fun existeTituloApp(): ActividadListaPeliculasPageObject {
        Espresso.onView(
            Matchers.allOf(withId(R.id.tituloAppTextView), ViewMatchers.withText("AndroidBase"),
                ViewMatchers.withParent(ViewMatchers.withParent(IsInstanceOf.instanceOf(ScrollView::class.java))),
                ViewMatchers.isDisplayed()))
        return this
    }

    fun existeScrollView(): ActividadListaPeliculasPageObject {
        Espresso.onView(
            Matchers.allOf(ViewMatchers.withParent(ViewMatchers.withParent(withId(android.R.id.content))),
                ViewMatchers.isDisplayed()))
        return this
    }

    fun existeRecyclerView(): ActividadListaPeliculasPageObject {
        Espresso.onView(
            Matchers.allOf(ViewMatchers.withParent(Matchers.allOf(withId(R.id.listaPeliculasRecyclerview),
                ViewMatchers.withParent(IsInstanceOf.instanceOf(ViewGroup::class.java)))),
                ViewMatchers.isDisplayed()))
        return this
    }

    fun existeCartelPelicula(): ActividadListaPeliculasPageObject {
        Espresso.onView(
            Matchers.allOf(withId(R.id.cartelPeliculaImageView),
                ViewMatchers.withParent(ViewMatchers.withParent(withId(R.id.listaPeliculasRecyclerview))),
                ViewMatchers.isDisplayed()))
        return this

    }

    fun existeTituloPelicula(): ActividadListaPeliculasPageObject {
        Espresso.onView(
            Matchers.allOf(withId(R.id.tituloPeliculaTextView), ViewMatchers.withText("Pelicula:"),
                ViewMatchers.withParent(ViewMatchers.withParent(withId(R.id.listaPeliculasRecyclerview))),
                ViewMatchers.isDisplayed()))
        return this
    }

    fun existeInfoTextoTituloPelicula(): ActividadListaPeliculasPageObject {
        Espresso.onView(
            Matchers.allOf(withId(R.id.textoPeliculaTextView),
                ViewMatchers.withParent(ViewMatchers.withParent(withId(R.id.listaPeliculasRecyclerview))),
                ViewMatchers.isDisplayed()))
        return this
    }

    fun existeTituloIdioma(): ActividadListaPeliculasPageObject {
        Espresso.onView(
            Matchers.allOf(withId(R.id.tituloIdiomaTextView), ViewMatchers.withText("Idioma:"),
                ViewMatchers.withParent(ViewMatchers.withParent(withId(R.id.listaPeliculasRecyclerview))),
                ViewMatchers.isDisplayed()))
        return this
    }

    fun existeInfoTextoIdioma(): ActividadListaPeliculasPageObject {
        Espresso.onView(
            Matchers.allOf(withId(R.id.textoIdiomaTextView),
                ViewMatchers.withParent(ViewMatchers.withParent(withId(R.id.listaPeliculasRecyclerview))),
                ViewMatchers.isDisplayed()))
        return this
    }

    fun existeTituloVotacion(): ActividadListaPeliculasPageObject {
        Espresso.onView(
            Matchers.allOf(withId(R.id.tituloVotacionTextView), ViewMatchers.withText("Votacion:"),
                ViewMatchers.withParent(ViewMatchers.withParent(withId(R.id.listaPeliculasRecyclerview))),
                ViewMatchers.isDisplayed()))
        return this
    }

    fun existeInfoTextoVotacion(): ActividadListaPeliculasPageObject {
        Espresso.onView(
            Matchers.allOf(withId(R.id.textoVotacionTextView),
                ViewMatchers.withParent(ViewMatchers.withParent(withId(R.id.listaPeliculasRecyclerview))),
                ViewMatchers.isDisplayed()))
        return this
    }

    fun existeBotonVerDetallePeliculas(): ActividadListaPeliculasPageObject {
        Espresso.onView(
            Matchers.allOf(withId(R.id.btn_ver_detalle), ViewMatchers.withText("Ver"),
                ViewMatchers.withParent(ViewMatchers.withParent(withId(R.id.listaPeliculasRecyclerview))),
                ViewMatchers.isDisplayed()))
        return this
    }

    fun clickBotonVerDetalles(): ActividadListaPeliculasPageObject {

        Espresso.onView(
            Matchers.allOf(withId(R.id.btn_ver_detalle),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.listaPeliculasRecyclerview),
                        0),
                    7)))
            .perform(scrollTo(), click())
        return this
    }

    fun verificarLanzamientoActividadDetalle(): ActividadListaPeliculasPageObject {
        intended(hasComponent(ActividadDetallePelicula::class.java.name))
        return this
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