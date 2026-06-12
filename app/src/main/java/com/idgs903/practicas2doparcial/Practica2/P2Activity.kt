package com.idgs903.practicas2doparcial.Practica2

import android.content.Intent
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

class P2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_p2)

        val btn = findViewById<Button>(R.id.btnCalcular)
        val edtA = findViewById<EditText>(R.id.edtA)
        val edtB = findViewById<EditText>(R.id.edtB)
        val edtC = findViewById<EditText>(R.id.edtC)

        btn.setOnClickListener {
            if (edtA.text.isEmpty() || edtB.text.isEmpty() || edtC.text.isEmpty()){
                val toast = Toast.makeText(this,"Llene todos los campos",Toast.LENGTH_SHORT)
                toast.show()
                return@setOnClickListener
            }

            val ladoA = Integer.parseInt(edtA.text.toString())
            val ladoB = Integer.parseInt(edtB.text.toString())
            val ladoC = Integer.parseInt(edtC.text.toString())

            if(ladoA + ladoB > ladoC || ladoC + ladoB > ladoA || ladoA + ladoC > ladoB){
                val s = ((ladoA + ladoB + ladoC) / 2).toDouble()
                val area = Math.sqrt(s*(s-ladoA)*(s-ladoB)*(s-ladoC))
                val intent = Intent(this, AreaActivity::class.java)
                intent.putExtra("AREA",area.toString())
                startActivity(intent)
            }else{
                val toast = Toast.makeText(this,"Los lados introducidos no forman un triangulo",Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}