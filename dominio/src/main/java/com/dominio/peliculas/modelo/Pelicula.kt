package com.dominio.peliculas.modelo

import com.dominio.peliculas.excepcion.ExcepcionNulo
import com.google.gson.annotations.SerializedName

data class Pelicula(

    val id: Int?,
    @SerializedName("original_language") var idioma: String?,
    @SerializedName("original_title") var titulo: String?,
    @SerializedName("poster_path") var imagenUrl: String?,
    @SerializedName("vote_average") var calificacion: Float?,
    @SerializedName("release_date") var fechaLanzamiento: String?,
    @SerializedName("overview") var descripcion: String?,

    ) {
    init {
        if (validacionNulo()) throw ExcepcionNulo()
    }

    private fun validacionNulo(): Boolean = id == null || idioma == null || titulo == null || imagenUrl == null
            || calificacion == null || fechaLanzamiento == null || descripcion == null

}