package com.infraestructura.accesodatos.accesodatosapi.servicioapi

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.infraestructura.accesodatos.accesodatosapi.urlbase.PuntoFinal.Companion.GET_TRENDING
import retrofit2.http.GET

interface ServicioApi {

    @GET(GET_TRENDING)
    suspend fun obtenerpagina(): PaginadoPeliculas
}