package com.infraestructura.accesodatos.accesodatoslocal.basedatos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.infraestructura.accesodatos.accesodatoslocal.dao.PeliculasDao
import com.infraestructura.accesodatos.modelos.entidadbasedatos.EntidadBaseDatosPelicula

@Database(entities = [EntidadBaseDatosPelicula::class], version = 2, exportSchema = false)
abstract class BaseDatosPaginaPeliculas : RoomDatabase() {

    abstract fun peliculasDao(): PeliculasDao

}