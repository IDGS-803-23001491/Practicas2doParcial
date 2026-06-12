package com.idgs903.practicas2doparcial.Practica3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.idgs903.practicas2doparcial.R

class ZodiacoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_zodiaco)

        val txtSaludo = findViewById<TextView>(R.id.txtSaludo)
        val txtEdad = findViewById<TextView>(R.id.txtEdad)
        val txtZodiaco = findViewById<TextView>(R.id.txtZodiaco)
        val txtGenero = findViewById<TextView>(R.id.txtGenero)
        val img = findViewById<ImageView>(R.id.img)

        val nombre:String = intent.extras?.getString("NOMBRE").orEmpty()
        txtSaludo.text = "Hola $nombre"

        val edad:String = intent.extras?.getString("EDAD").orEmpty()
        txtEdad.text = "Tienes $edad años"

        val signo:String = intent.extras?.getString("SIGNO").orEmpty()
        txtZodiaco.text = "Tu signo zodiacal es $signo"

        val genero:String = intent.extras?.getString("GENERO").orEmpty()
        txtGenero.text = "Tu genero es $genero"

        when (signo) {
            "mono" -> img.setImageResource(R.drawable.mono)
            "gallo" -> img.setImageResource(R.drawable.gallo)
            "perro" -> img.setImageResource(R.drawable.perro)
            "cerdo" -> img.setImageResource(R.drawable.cerdo)
            "rata" -> img.setImageResource(R.drawable.rata)
            "buey" -> img.setImageResource(R.drawable.buey)
            "tigre" -> img.setImageResource(R.drawable.tigre)
            "conejo" -> img.setImageResource(R.drawable.conejo)
            "dragón" -> img.setImageResource(R.drawable.dragon)
            "serpiente" -> img.setImageResource(R.drawable.serpiente)
            "caballo" -> img.setImageResource(R.drawable.caballo)
            "cabra" -> img.setImageResource(R.drawable.cabra)
            else -> ""
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}