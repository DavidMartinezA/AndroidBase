package com.infraestructura.accesodatos.accesodatoslocal.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.infraestructura.accesodatos.accesodatoslocal.entidadbasedatos.EntidadBaseDatosPelicula

interface PaginaPeliculasDao {

    @Query("SELECT * FROM EntidadBaseDatosPelicula")
    suspend fun obtener(): EntidadBaseDatosPelicula

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertar(entidadDatosUsuario: EntidadBaseDatosPelicula)
}