package com.infraestructura.accesodatos.accesodatoslocal.entidadbasedatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EntidadBaseDatosPelicula(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var lenguaje: String?,
    var titulo: String?,
    var imagen: String?,
    var votacion: Float?,
    var fechaLanzamiento: String?,
    var descripcion: String?,
    var diaRegistro: Int,
)