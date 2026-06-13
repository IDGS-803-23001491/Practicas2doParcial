package com.idgs903.practicas2doparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.idgs903.practicas2doparcial.Practica1.P1Activity
import com.idgs903.practicas2doparcial.Practica2.P2Activity
import com.idgs903.practicas2doparcial.Practica3.P3Activity
import com.idgs903.practicas2doparcial.Practica4.P4Activity
import com.idgs903.practicas2doparcial.Practica5.P5Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)

        btn1.setOnClickListener { navegarP1() }
        btn2.setOnClickListener { navegarP2() }
        btn3.setOnClickListener { navegarP3() }
        btn4.setOnClickListener { navegarP4() }
        btn5.setOnClickListener { navegarP5() }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun navegarP1(){
        val intent = Intent(this, P1Activity::class.java)
        startActivity(
            intent
        )
    }
    fun navegarP2(){
        val intent = Intent(this, P2Activity::class.java)
        startActivity(
            intent
        )
    }
    fun navegarP3(){
        val intent = Intent(this, P3Activity::class.java)
        startActivity(
            intent
        )
    }

    fun navegarP4(){
        val intent = Intent(this, P4Activity::class.java)
        startActivity(
            intent
        )
    }

    fun navegarP5(){
        val intent = Intent(this, P5Activity::class.java)
        startActivity(
            intent
        )
    }
}