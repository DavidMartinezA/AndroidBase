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
import com.androidbase.detallepeliculas.ActividadDetallePelicula
import com.dominio.peliculas.modelo.Pelicula
import com.squareup.picasso.Picasso

class AdaptadorListaPeliculas(private var resultadoPeliculas: ArrayList<Pelicula>) :
    RecyclerView.Adapter<AdaptadorListaPeliculas.ViewHolder>() {

    companion object {
        const val TITULO = "Titulo"
        const val IDIOMA = "Titulo"
        const val IMAGEN = "Titulo"
        const val CALIFICACION = "Titulo"
        const val FECHA_LANZAMIENTO = "Titulo"
        const val DESCRIPCION = "Titulo"
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.modelo_pelicula_vista, parent, false))
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(pelicula: Pelicula) {

            view.findViewById<TextView>(R.id.textoPeliculaTextView).text = pelicula.titulo
            view.findViewById<TextView>(R.id.textoIdiomaTextView).text = pelicula.idioma
            view.findViewById<TextView>(R.id.textoVotacionTextView).text = pelicula.calificacion.toString()
            val imagenUrl = pelicula.imagenUrl
            val imagen = view.findViewById<ImageView>(R.id.cartelPeliculaImageView)

            Picasso.get()
                .load("https://developers.themoviedb.org/3/trending/get-trending$imagenUrl")
                .resize(50, 50)
                .centerCrop()
                .into(imagen)
            view.findViewById<Button>(R.id.btn_ver_detalle).setOnClickListener {

                //Send data and open PostActivity
                val intent = Intent(view.context, ActividadDetallePelicula::class.java)
                intent.putExtra(TITULO, pelicula.titulo)
                intent.putExtra(IDIOMA, pelicula.idioma)
                intent.putExtra(IMAGEN, pelicula.imagenUrl)
                intent.putExtra(CALIFICACION, pelicula.calificacion)
                intent.putExtra(FECHA_LANZAMIENTO, pelicula.fechaLanzamiento)
                intent.putExtra(DESCRIPCION, pelicula.descripcion)
                view.context.startActivity(intent)
            }
        }
    }

    //Sending the object for views
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(resultadoPeliculas[position])
    }

    //Getting list size
    override fun getItemCount(): Int = resultadoPeliculas.size

}