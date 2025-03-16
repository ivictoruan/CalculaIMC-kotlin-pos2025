package com.example.calculaimc_kotlin_pos2025

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    //Mesmo que "late" no Dart
    private lateinit var etPeso : EditText
    private lateinit var etAltura : EditText
    private lateinit var tvImcResutado : TextView
    private lateinit var btCalcular : Button
    private lateinit var btLimpar : Button

   private fun onIniMainActivity(){
        etPeso = findViewById( R.id.etPeso )
        etAltura = findViewById( R.id.etAltura )
        tvImcResutado = findViewById( R.id.tvImcResutado )
        btCalcular = findViewById( R.id.btCalcular )
        btLimpar = findViewById( R.id.btLimpar )
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        onIniMainActivity()

        startButtonLiteners()

    }


    private fun startButtonLiteners(){

        btCalcular.setOnClickListener{
            onCalcularBtClick()
        }

        btLimpar.setOnClickListener{
            onLimparBtClick()

        }
    }
    private fun onCalcularBtClick() {
        if(etPeso.text.toString().isEmpty()  ){
            etPeso.setError("O campo peso deve ser preenchido.")
            return
        }
        if(etAltura.text.toString().isEmpty()  ){
            etAltura.setError("O campo altura deve ser preenchido.")
            return
        }

        val peso :Double = etPeso.text.toString().toDouble()
        val altura :Double = etAltura.text.toString().toDouble()

        val imc: Double = (peso / altura.pow(2) * 10000)

        val df = DecimalFormat("0.0")

        tvImcResutado.text = df.format(imc)


    }
    private fun onLimparBtClick() {
        etPeso.text.clear()
        etAltura.text.clear()
        tvImcResutado.text = 0.0.toString()
        etPeso.requestFocus()
    }

}