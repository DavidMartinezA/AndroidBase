package com.androidbase.listapeliculas.adaptadorlistapeliculas

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidbase.R
import com.androidbase.listapeliculas.vista.actividaddetallepeliculas.ActividadDetallePelicula
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

            view.findViewById<TextView>(R.id.textoPeliculaTextView).text = pelicula.titulo
            view.findViewById<TextView>(R.id.textoIdiomaTextView).text = pelicula.lenguaje
            view.findViewById<TextView>(R.id.textoVotacionTextView).text = pelicula.votacion.toString()
            val imagenUrl = pelicula.imagenUrl
            val imagen = view.findViewById<ImageView>(R.id.cartelPeliculaImageView)

            Picasso.get()
                .load(URL_BASE_IMAGEN + imagenUrl)
                .resize(50, 80)
                .centerCrop()
                .into(imagen)

            view.findViewById<Button>(R.id.btn_ver_detalle).setOnClickListener {

                val intent = Intent(view.context, ActividadDetallePelicula::class.java)
                intent.putExtra(TITULO, pelicula.titulo)
                intent.putExtra(IDIOMA, pelicula.lenguaje)
                intent.putExtra(IMAGEN, pelicula.imagenUrl)
                intent.putExtra(CALIFICACION, pelicula.votacion.toString())
                intent.putExtra(FECHA_LANZAMIENTO, pelicula.fechaLanzamiento)
                intent.putExtra(DESCRIPCION, pelicula.descripcion)
                view.context.startActivity(intent)


            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(resultadoPeliculas[position])
    }

    override fun getItemCount(): Int = resultadoPeliculas.size

}