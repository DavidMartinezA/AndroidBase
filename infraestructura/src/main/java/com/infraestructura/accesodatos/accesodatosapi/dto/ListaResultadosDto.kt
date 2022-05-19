package com.infraestructura.accesodatos.accesodatosapi.dto

import com.google.gson.annotations.SerializedName

data class ListaResultadosDto(

    val id: Int = 0,
    @SerializedName("original_language") var lenguaje: String?,
    @SerializedName("original_title") var titulo: String?,
    @SerializedName("poster_path") var imagenUrl: String?,
    @SerializedName("vote_average") var votacion: Float?,
    @SerializedName("release_date") var fechaLanzamiento: String?,
    @SerializedName("overview") var descripcion: String?,
    var diaRegistro: Int = 0,
)


