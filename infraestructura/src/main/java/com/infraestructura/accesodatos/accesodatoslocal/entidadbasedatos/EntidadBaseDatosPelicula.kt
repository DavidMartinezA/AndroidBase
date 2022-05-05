package com.infraestructura.accesodatos.accesodatoslocal.entidadbasedatos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dominio.peliculas.modelo.Pelicula

@Entity
class EntidadBaseDatosPelicula(
    @PrimaryKey(autoGenerate = true)

    var pagina: Int?,
    var resultadoPeliculas: ArrayList<Pelicula>?,
    var paginasTotales: Int?,
    var resultadoTotal: Int?,
)