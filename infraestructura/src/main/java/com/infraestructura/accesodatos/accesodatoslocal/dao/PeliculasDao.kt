package com.infraestructura.accesodatos.accesodatoslocal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.infraestructura.accesodatos.accesodatoslocal.entidadbasedatos.EntidadBaseDatosPelicula

@Dao
interface PeliculasDao {

    @Query("SELECT * FROM EntidadBaseDatosPelicula")
    suspend fun obtener(): List<EntidadBaseDatosPelicula>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(entidadBaseDatosPelicula: EntidadBaseDatosPelicula)

}