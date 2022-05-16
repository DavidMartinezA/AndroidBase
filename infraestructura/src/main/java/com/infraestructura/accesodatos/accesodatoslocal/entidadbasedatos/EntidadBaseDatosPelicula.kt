package com.infraestructura.accesodatos.accesodatoslocal.entidadbasedatos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dominio.peliculas.modelo.Pelicula

@Entity
class EntidadBaseDatosPelicula(

    @PrimaryKey(autoGenerate = true)
    var pagina: Int?,
    var resultadoPeliculas: List<Pelicula>?,
    var paginasTotales: Int?,
    var resultadoTotal: Int?,
    var diaRegistro: Int,
)