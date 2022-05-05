package com.infraestructura.accesodatos.accesodatosapi.configuracionapi

import com.infraestructura.accesodatos.accesodatosapi.servicioapi.ServicioApi
import com.infraestructura.accesodatos.accesodatosapi.urlbase.PuntoFinal.Companion.URL_BASE
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ConfiguracionApi {

    private fun obtenerOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    private fun obtenerRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(URL_BASE)
            .client(obtenerOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun obtenerServicioApi(): ServicioApi {
        return obtenerRetrofit().create(ServicioApi::class.java)
    }
}