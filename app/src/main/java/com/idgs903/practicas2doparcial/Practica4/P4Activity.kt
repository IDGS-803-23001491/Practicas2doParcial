package com.idgs903.practicas2doparcial.Practica4

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.idgs903.practicas2doparcial.R

class P4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_p4)

        val spn1 = findViewById<Spinner>(R.id.spn1)
        val spn2 = findViewById<Spinner>(R.id.spn2)
        val spn3 = findViewById<Spinner>(R.id.spn3)
        val txt1 = findViewById<TextView>(R.id.txt1)
        val txt2 = findViewById<TextView>(R.id.txt2)
        val txt3 = findViewById<TextView>(R.id.txt3)
        val btnPlata = findViewById<RadioButton>(R.id.btnPlata)
        val btnOro = findViewById<RadioButton>(R.id.btnOro)
        val rgp = findViewById<RadioGroup>(R.id.rdb)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtValor = findViewById<TextView>(R.id.txtVal)
        val txtMaximo = findViewById<TextView>(R.id.txtMaximo)
        val txtMinimo = findViewById<TextView>(R.id.txtMinimo)

        val listaColores = arrayListOf(
            "Elija un color",
            "Negro",
            "Marrón",
            "Rojo",
            "Naranja",
            "Amarillo",
            "Verde",
            "Azul",
            "Violeta",
            "Gris",
            "Blanco"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            listaColores
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spn1.adapter = adapter
        spn2.adapter = adapter
        spn3.adapter = adapter

        spn1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccionado = parent?.getItemAtPosition(position)
                when (seleccionado.toString()){
                    "Negro" -> txt1.setText("0")
                    "Marrón" -> txt1.setText("1")
                    "Rojo" -> txt1.setText("2")
                    "Naranja" -> txt1.setText("3")
                    "Amarillo" -> txt1.setText("4")
                    "Verde" -> txt1.setText("5")
                    "Azul" -> txt1.setText("6")
                    "Violeta" -> txt1.setText("7")
                    "Gris" -> txt1.setText("8")
                    "Blanco" -> txt1.setText("9")
                    else -> ""
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        spn2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccionado = parent?.getItemAtPosition(position)
                when (seleccionado.toString()){
                    "Negro" -> txt2.setText("0")
                    "Marrón" -> txt2.setText("1")
                    "Rojo" -> txt2.setText("2")
                    "Naranja" -> txt2.setText("3")
                    "Amarillo" -> txt2.setText("4")
                    "Verde" -> txt2.setText("5")
                    "Azul" -> txt2.setText("6")
                    "Violeta" -> txt2.setText("7")
                    "Gris" -> txt2.setText("8")
                    "Blanco" -> txt2.setText("9")
                    else -> ""
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        spn3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccionado = parent?.getItemAtPosition(position)
                when (seleccionado.toString()){
                    "Negro" -> txt3.setText("1")
                    "Marrón" -> txt3.setText("10")
                    "Rojo" -> txt3.setText("100")
                    "Naranja" -> txt3.setText("1,000")
                    "Amarillo" -> txt3.setText("10,000")
                    "Verde" -> txt3.setText("100,000")
                    "Azul" -> txt3.setText("1,000,000")
                    "Violeta" -> txt3.setText("10,000,000")
                    "Gris" -> txt3.setText("100,000,000")
                    "Blanco" -> txt3.setText("1,000,000,000")
                    else -> ""
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        btnCalcular.setOnClickListener {

            if (txt1.text.isEmpty() || txt2.text.isEmpty() || txt3.text.isEmpty() || rgp.checkedRadioButtonId == -1){
                Toast.makeText(this,"Seleccione todos los campos",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val valor = (
                    txt1.text.toString().toInt().toString() +
                            txt2.text.toString().toInt().toString()
                    ).toLong() *
                    txt3.text.toString().replace(",", "").toLong()

            val tolerancia = when {
                btnOro.isChecked -> 0.05
                btnPlata.isChecked -> 0.10
                else -> 0.0
            }

            val minimo = valor - (valor * tolerancia)
            val maximo = valor + (valor * tolerancia)

            txtValor.setText("${valor} ohms")
            txtMinimo.setText("${minimo.toLong()} ohms")
            txtMaximo.setText("${maximo.toLong()} ohms")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}