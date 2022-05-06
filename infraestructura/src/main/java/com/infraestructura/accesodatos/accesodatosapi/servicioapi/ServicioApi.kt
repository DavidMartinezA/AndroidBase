package com.infraestructura.accesodatos.accesodatosapi.servicioapi

import com.dominio.peliculas.modelo.PaginadoPeliculas
import retrofit2.http.GET

interface ServicioApi {

    @GET
    suspend fun obtenerpagina(): PaginadoPeliculas
}