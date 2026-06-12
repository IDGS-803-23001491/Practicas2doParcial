package com.idgs903.practicas2doparcial.Practica1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.idgs903.practicas2doparcial.R

class P1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_p1)

        val btn = findViewById<Button>(R.id.btnCalcular)
        val edtX1 = findViewById<EditText>(R.id.edtX1)
        val edtX2 = findViewById<EditText>(R.id.edtX2)
        val edtY1 = findViewById<EditText>(R.id.edtY1)
        val edtY2 = findViewById<EditText>(R.id.edtY2)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btn.setOnClickListener {

            if (edtX1.text.toString().isEmpty() || edtX2.text.toString().isEmpty()
                || edtY1.text.toString().isEmpty() || edtY2.text.toString().isEmpty()){
                val toast = Toast.makeText(this,"Llene todos los campos",Toast.LENGTH_SHORT)
                toast.show()
                return@setOnClickListener
            }

            val x1 = Integer.parseInt(edtX1.text.toString())
            val x2 = Integer.parseInt(edtX2.text.toString())
            val y1 = Integer.parseInt(edtY1.text.toString())
            val y2 = Integer.parseInt(edtY2.text.toString())

            val total = Math.sqrt( Math.pow(x2.toDouble() - x1.toDouble(),2.0) + Math.pow(y2.toDouble() - y1.toDouble(),2.0))
            txtResultado.setText(total.toString())
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}