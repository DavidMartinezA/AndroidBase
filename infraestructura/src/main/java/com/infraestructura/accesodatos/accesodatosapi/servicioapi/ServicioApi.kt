package com.infraestructura.accesodatos.accesodatosapi.servicioapi

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.infraestructura.accesodatos.accesodatosapi.urlbase.PuntoFinal.Companion.URL_BASE
import retrofit2.http.GET

interface ServicioApi {

    @GET(URL_BASE)
    suspend fun obtenerpagina(): PaginadoPeliculas
}