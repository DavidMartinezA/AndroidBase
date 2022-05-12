package com.androidbase.detallepeliculas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidbase.databinding.ActividadDetallePeliculaBinding


class ActividadDetallePelicula : AppCompatActivity() {

    private lateinit var binding: ActividadDetallePeliculaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActividadDetallePeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}
