package com.infraestructura.accesodatos.accesodatoslocal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.infraestructura.accesodatos.modelos.entidadbasedatos.EntidadBaseDatosPelicula

@Dao
interface PeliculasDao {

    @Query("SELECT * FROM EntidadBaseDatosPelicula")
    suspend fun obtener(): List<EntidadBaseDatosPelicula>

    @Query("DELETE  FROM EntidadBaseDatosPelicula")
    suspend fun borrar()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(entidadBaseDatosPelicula: EntidadBaseDatosPelicula)

}