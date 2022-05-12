package com.androidbase.detallepeliculas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidbase.databinding.ActividadDetallePeliculaBinding
import com.androidbase.listapeliculas.adaptadorlistapeliculas.AdaptadorListaPeliculas.Companion.CALIFICACION
import com.androidbase.listapeliculas.adaptadorlistapeliculas.AdaptadorListaPeliculas.Companion.DESCRIPCION
import com.androidbase.listapeliculas.adaptadorlistapeliculas.AdaptadorListaPeliculas.Companion.FECHA_LANZAMIENTO
import com.androidbase.listapeliculas.adaptadorlistapeliculas.AdaptadorListaPeliculas.Companion.IDIOMA
import com.androidbase.listapeliculas.adaptadorlistapeliculas.AdaptadorListaPeliculas.Companion.IMAGEN
import com.androidbase.listapeliculas.adaptadorlistapeliculas.AdaptadorListaPeliculas.Companion.TITULO
import com.squareup.picasso.Picasso

class ActividadDetallePelicula : AppCompatActivity() {

    private lateinit var binding: ActividadDetallePeliculaBinding
    private lateinit var titulo: String
    private lateinit var idioma: String
    private lateinit var imagenUrl: String
    private lateinit var calificacion: String
    private lateinit var fechaLanzamiento: String
    private lateinit var descripcion: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActividadDetallePeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        titulo = intent.getStringExtra(TITULO).toString()
        idioma = intent.getStringExtra(IDIOMA).toString()
        imagenUrl = intent.getStringExtra(IMAGEN).toString()
        calificacion = intent.getStringExtra(CALIFICACION).toString()
        fechaLanzamiento = intent.getStringExtra(FECHA_LANZAMIENTO).toString()
        descripcion = intent.getStringExtra(DESCRIPCION).toString()

        obtenerImagen()
        mostrarInformacionPelicula()
        mostrarDestallePelicula()

    }

    private fun obtenerImagen() {

        if (imagenUrl.isNotEmpty()) {
            val imagen = binding.cartelPeliculaDetalleImageView
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500$imagenUrl")
                .resize(50, 80)
                .centerCrop()
                .into(imagen)
        }
    }

    private fun mostrarInformacionPelicula() {

        binding.textoPeliculaTextView.text = titulo
        binding.textoIdiomaDetalleTextView.text = idioma
        binding.textoVotacionTextView.text = calificacion
    }

    private fun mostrarDestallePelicula() {

        binding.textoFechaLanzamientoTextView.text = fechaLanzamiento
        binding.textoSipnosisTextView.text = descripcion
    }
}
