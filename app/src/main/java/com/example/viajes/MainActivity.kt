package com.example.viajes

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.viajes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaLugares = listOf(
            Lugar ("Paris","https://i.imgur.com/QErAXxO.jpg","48.85341, 2.3488"),
            Lugar ("Sevilla","https://i.imgur.com/Gb2HR1f.png","37.3828300,-5.9731700"),
            Lugar ("Cadiz","https://i.imgur.com/uwTpMRo.png","36.5297800,-6.2946500"),
            )


        binding.recview.adapter = lugarAdapter(listaLugares){
            val coordenada = it.cod;
            val gmmIntentUri = Uri.parse("google.streetview:cbll=" + coordenada)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)

        }

    }
}