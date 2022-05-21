package com.dominio.peliculas.modelo

class ConstructorPeliculasPruebas {

    private var lenguaje: String = "Prueba"
    private var titulo: String = "Prueba"
    private var imagenUrl: String = "Prueba"
    private var votacion: Float = 0.0F
    private var fechaLanzamiento: String = "Prueba"
    private var descripcion: String = "Prueba"

    fun conLenguaje(lenguaje: String): ConstructorPeliculasPruebas {
        this.lenguaje = lenguaje
        return this
    }

    fun conTitulo(titulo: String): ConstructorPeliculasPruebas {
        this.titulo = titulo
        return this
    }

    fun conImagen(imagen: String): ConstructorPeliculasPruebas {
        this.imagenUrl = imagen
        return this
    }

    fun conVotacion(votacion: Float): ConstructorPeliculasPruebas {
        this.votacion = votacion
        return this
    }

    fun conFechaLanzamiento(fechaLanzamiento: String): ConstructorPeliculasPruebas {
        this.fechaLanzamiento = fechaLanzamiento
        return this
    }

    fun conDescripcion(descripcion: String): ConstructorPeliculasPruebas {
        this.descripcion = descripcion
        return this
    }

    fun build(): Pelicula = Pelicula(lenguaje, titulo, imagenUrl, votacion, fechaLanzamiento, descripcion)
}