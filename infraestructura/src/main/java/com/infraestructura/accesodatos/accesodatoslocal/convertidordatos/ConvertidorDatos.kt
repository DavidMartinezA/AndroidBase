package com.infraestructura.accesodatos.accesodatoslocal.convertidordatos

import androidx.room.TypeConverter
import com.dominio.peliculas.modelo.Pelicula
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ConvertidorDatos {

    @TypeConverter
    fun dePeliculaATexto(list: List<Pelicula?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun deTextoAPelicula(value: String?): ArrayList<Pelicula>? {
        val tipo: Type = object : TypeToken<ArrayList<Pelicula>?>() {}.type
        return Gson().fromJson(value, tipo)
    }

}