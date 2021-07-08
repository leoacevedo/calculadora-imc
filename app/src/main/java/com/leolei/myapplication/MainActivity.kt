package com.leolei.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alturaEt: EditText = findViewById(R.id.altura)
        val pesoEt: EditText = findViewById(R.id.peso)
        val calcularBtn: Button = findViewById(R.id.calcular)
        val imcTv: TextView = findViewById(R.id.imc)
        val diagnosticoTv: TextView = findViewById(R.id.diagnostico)

        calcularBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val alturaCm = alturaEt.text.toString().toInt()
                val pesoKg = pesoEt.text.toString().toInt()

                val imc = calcularImc(alturaCm, pesoKg)
                imcTv.text = imc.toString()

                val diagnosticoInt = diagnostico(imc)
                val diagnostico = when (diagnosticoInt) {
                    0 -> "Bajo peso"
                    1 -> "Normal"
                    2 -> "Sobrepeso"
                    else -> "Obeso"
                }
                diagnosticoTv.text = diagnostico
            }
        })
    }

    private fun calcularImc(alturaCm: Int, pesoKg: Int): Float {
        val alturaMts: Float = alturaCm / 100f
        return pesoKg / (alturaMts * alturaMts)
    }

    private fun diagnostico(imc: Float): Int {
        return when  {
            imc < 18.5 ->  0
            imc < 24.9 -> 1
            imc < 29.9 -> 2
            else -> 3
        }
    }
}

