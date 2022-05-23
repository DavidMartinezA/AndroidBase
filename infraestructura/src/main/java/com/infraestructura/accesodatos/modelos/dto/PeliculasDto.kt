package com.infraestructura.accesodatos.modelos.dto

import com.google.gson.annotations.SerializedName

data class PeliculasDto(

    @SerializedName("page") private var pagina: Int,
    @SerializedName("results") var resultadoPeliculas: List<ListaResultadosDto>,
    @SerializedName("total_pages") private var paginasTotales: Int,
    @SerializedName("total_results") private var resultadosTotales: Int,
)