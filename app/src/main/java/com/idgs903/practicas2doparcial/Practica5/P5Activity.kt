package com.idgs903.practicas2doparcial.Practica5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.idgs903.practicas2doparcial.R
import java.math.BigDecimal
import java.math.RoundingMode

class P5Activity : AppCompatActivity() {
    val costoBoleto = 12.0
    var descuento = 1.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_p5)

        val txtNombre = findViewById<EditText>(R.id.txtCNombre)
        val txtCompradors = findViewById<EditText>(R.id.txtCompradores)
        val txtBoletos = findViewById<EditText>(R.id.txtBoletos)
        val btnSi = findViewById<RadioButton>(R.id.rbtnSi)
        val btnCalcular = findViewById<Button>(R.id.btnProcesar)
        val btnSalir = findViewById<Button>(R.id.btnSalir)
        val txtResultado = findViewById<TextView>(R.id.txtTotal)
        val txtComprador = findViewById<TextView>(R.id.txtNomCom)
        val txtMax = findViewById<TextView>(R.id.txtMaxBol)
        val radioBoleto = findViewById<RadioGroup>(R.id.radioBoleto)

        btnCalcular.setOnClickListener {
            val boletos = txtBoletos.text.toString()
            val compradores = txtCompradors.text.toString()
            if (txtNombre.text.isEmpty() || compradores.isEmpty() || boletos.isEmpty() || radioBoleto.checkedRadioButtonId == -1){
                Toast.makeText(this, "LLene todos los campos",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val maximo = compradores.toInt() * 7

            if (boletos.toInt() > maximo){
                Toast.makeText(this, "No puede comprar tantos boletos, su límite son ${maximo} boletos",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (boletos.toInt() in 3..5){
                descuento = 0.9
            }
            else if ( boletos.toInt() > 5 ){
                descuento = 0.85
            }

            var total = boletos.toInt() * costoBoleto * descuento

            if (btnSi.isChecked){
                total = (total * 0.9)
            }

            total = BigDecimal(total)
                .setScale(2, RoundingMode.HALF_UP) // Redondeo clásico
                .toDouble()

            txtResultado.setText("${total}")
            txtComprador.setText(txtNombre.text.toString())
            txtMax.setText("${maximo} boletos")
        }

        btnSalir.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}