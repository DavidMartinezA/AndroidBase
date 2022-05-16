package com.infraestructura.accesodatos.accesodatosapi.servicioapi

import com.dominio.peliculas.modelo.PaginadoPeliculas
import com.infraestructura.accesodatos.accesodatosapi.urlbase.PuntoFinal.Companion.OBTENER_TENDENCIAS
import retrofit2.http.GET

interface ServicioApi {

    @GET(OBTENER_TENDENCIAS)
    suspend fun obtenerPagina(): PaginadoPeliculas
}