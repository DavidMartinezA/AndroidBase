package com.infraestructura.accesodatos.accesodatosapi.servicioapi

import com.infraestructura.accesodatos.accesodatosapi.dto.PeliculasDto
import com.infraestructura.accesodatos.accesodatosapi.urlbase.PuntoFinal.Companion.OBTENER_TENDENCIAS
import retrofit2.http.GET

interface ServicioApi {

    @GET(OBTENER_TENDENCIAS)
    suspend fun obtenerPagina(): PeliculasDto
}