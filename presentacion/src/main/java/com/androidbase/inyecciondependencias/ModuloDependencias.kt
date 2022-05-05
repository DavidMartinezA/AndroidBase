package com.androidbase.inyecciondependencias

import android.content.Context
import androidx.room.Room
import com.androidbase.R
import com.dominio.peliculas.repositorio.RepositorioPelicula
import com.infraestructura.accesodatos.accesodatoslocal.basedatos.BaseDatosPaginaPeliculas
import com.infraestructura.accesodatos.accesodatoslocal.repositorio.RepositorioPeliculasRoom
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ModuloDependencias {

    companion object {

        @Provides
        @Singleton
        fun proveerBaseDatos(@ApplicationContext contexto: Context): BaseDatosPaginaPeliculas {
            return Room.databaseBuilder(
                contexto, BaseDatosPaginaPeliculas::class.java,
                R.string.nombre_base_datos.toString())
                .build()
        }
    }

    @Binds
    abstract fun proveerRepositorio(repositorio: RepositorioPeliculasRoom): RepositorioPelicula
}