package com.androidbase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidbase.databinding.ActividadListaPeliculasBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActividadListaPeliculas : AppCompatActivity() {

    private lateinit var binding: ActividadListaPeliculasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActividadListaPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}



