package com.infraestructura.accesodatos.accesodatosapi.servicioapi

import com.infraestructura.accesodatos.accesodatosapi.urlbase.PuntoFinal.Companion.OBTENER_TENDENCIAS
import com.infraestructura.accesodatos.modelos.dto.PeliculasDto
import retrofit2.http.GET

interface ServicioApi {

    @GET(OBTENER_TENDENCIAS)
    suspend fun obtenerPagina(): PeliculasDto
}