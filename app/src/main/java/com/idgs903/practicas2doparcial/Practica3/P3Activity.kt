package com.idgs903.practicas2doparcial.Practica3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.idgs903.practicas2doparcial.Practica2.AreaActivity
import com.idgs903.practicas2doparcial.R
import java.time.LocalDate
import java.time.Period

class P3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_p3)

        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtPaterno = findViewById<EditText>(R.id.txtAPaterno)
        val txtMaterno = findViewById<EditText>(R.id.txtAMaterno)
        val txtDia = findViewById<EditText>(R.id.txtDia)
        val txtMes = findViewById<EditText>(R.id.txtMes)
        val txtAnio = findViewById<EditText>(R.id.txtAnio)
        val radio = findViewById<RadioGroup>(R.id.rdg)
        val btn = findViewById<Button>(R.id.btnImprimir)

        btn.setOnClickListener {
            if (txtNombre.text.toString().isEmpty() || txtPaterno.text.toString().isEmpty()
                || txtMaterno.text.toString().isEmpty() || txtDia.text.toString().isEmpty()
                || txtMes.text.toString().isEmpty() || txtAnio.text.toString().isEmpty()){

                val toast = Toast.makeText(this,"Llene todos los campos",Toast.LENGTH_SHORT)
                toast.show()
                return@setOnClickListener
            }

            val dia = Integer.parseInt(txtDia.text.toString())
            val mes = Integer.parseInt(txtMes.text.toString())
            val anio = Integer.parseInt(txtAnio.text.toString())
            val fechaNacimiento = LocalDate.of(anio, mes, dia)
            val fechaActual = LocalDate.now()
            val edad = Period.between(fechaNacimiento, fechaActual).years

            val signo = when (anio % 12) {
                0 -> "mono"
                1 -> "gallo"
                2 -> "perro"
                3 -> "cerdo"
                4 -> "rata"
                5 -> "buey"
                6 -> "tigre"
                7 -> "conejo"
                8 -> "dragón"
                9 -> "serpiente"
                10 -> "caballo"
                11 -> "cabra"
                else -> ""
            }

            val generoSeleccionado = radio.checkedRadioButtonId

            if (generoSeleccionado == -1) {
                val toast = Toast.makeText(this,"Llene todos los campos",Toast.LENGTH_SHORT)
                toast.show()
                return@setOnClickListener
            }
            val radioButton = findViewById<RadioButton>(generoSeleccionado)
            val genero = radioButton.text.toString()

            val nombre = txtNombre.text.toString() + " " + txtPaterno.text.toString() + " " + txtMaterno.text.toString()
            val intent = Intent(this, ZodiacoActivity::class.java)
            intent.putExtra("NOMBRE",nombre)
            intent.putExtra("EDAD",edad.toString())
            intent.putExtra("SIGNO",signo)
            intent.putExtra("GENERO",genero)

            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}