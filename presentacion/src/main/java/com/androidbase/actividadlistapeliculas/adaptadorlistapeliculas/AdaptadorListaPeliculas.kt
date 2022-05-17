package com.androidbase.actividadlistapeliculas.adaptadorlistapeliculas

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidbase.R
import com.androidbase.actividaddetallepeliculas.ActividadDetallePelicula
import com.dominio.peliculas.modelo.Pelicula
import com.infraestructura.accesodatos.accesodatosapi.urlbase.PuntoFinal.Companion.URL_BASE_IMAGEN
import com.squareup.picasso.Picasso

class AdaptadorListaPeliculas(private var resultadoPeliculas: List<Pelicula>) :
    RecyclerView.Adapter<AdaptadorListaPeliculas.ViewHolder>() {

    companion object {

        const val TITULO = "Titulo"
        const val IDIOMA = "Idioma"
        const val IMAGEN = "Imagen"
        const val CALIFICACION = "Califdicacion"
        const val FECHA_LANZAMIENTO = "Fecha de Lanzamiento"
        const val DESCRIPCION = "Descripcion"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.modelo_pelicula_vista, parent, false))
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(pelicula: Pelicula) {

            view.findViewById<TextView>(R.id.textoPeliculaTextView).text = pelicula.original_title
            view.findViewById<TextView>(R.id.textoIdiomaTextView).text = pelicula.original_language
            view.findViewById<TextView>(R.id.textoVotacionTextView).text = pelicula.vote_average.toString()
            val imagenUrl = pelicula.poster_path
            val imagen = view.findViewById<ImageView>(R.id.cartelPeliculaImageView)

            Picasso.get()
                .load(URL_BASE_IMAGEN + imagenUrl)
                .resize(50, 80)
                .centerCrop()
                .into(imagen)

            view.findViewById<Button>(R.id.btn_ver_detalle).setOnClickListener {

                val intent = Intent(view.context, ActividadDetallePelicula::class.java)
                intent.putExtra(TITULO, pelicula.original_title)
                intent.putExtra(IDIOMA, pelicula.original_language)
                intent.putExtra(IMAGEN, pelicula.poster_path)
                intent.putExtra(CALIFICACION, pelicula.vote_average.toString())
                intent.putExtra(FECHA_LANZAMIENTO, pelicula.release_date)
                intent.putExtra(DESCRIPCION, pelicula.overview)
                view.context.startActivity(intent)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(resultadoPeliculas[position])
    }

    override fun getItemCount(): Int = resultadoPeliculas.size

}