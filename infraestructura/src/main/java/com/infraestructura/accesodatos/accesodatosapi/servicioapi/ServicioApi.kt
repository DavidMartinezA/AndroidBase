package com.infraestructura.accesodatos.accesodatosapi.servicioapi

import com.dominio.peliculas.modelo.PaginadoPeliculas
import retrofit2.http.GET
import retrofit2.http.Url

interface ServicioApi {

    @GET
    suspend fun obtenerpagina(@Url url: String): PaginadoPeliculas
}