package com.leolei.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imcTv: TextView
    private lateinit var diagnosticoTv: TextView
    private lateinit var textResultado1: TextView
    private lateinit var textResultado2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alturaEt: EditText = findViewById(R.id.altura)
        val pesoEt: EditText = findViewById(R.id.peso)
        val calcularBtn: Button = findViewById(R.id.calcular)
        imcTv = findViewById(R.id.imc)
        diagnosticoTv = findViewById(R.id.diagnostico)
        textResultado1 = findViewById(R.id.tv_resultado_1)
        textResultado2 = findViewById(R.id.tv_resultado_2)

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

        val irOtraActivity = findViewById<Button>(R.id.ir_a_otra_activity)
        irOtraActivity.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                irOtraPantalla()
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            if (requestCode == SecondActivity.REQUEST) {
                if (data != null) {
                    val botonNro = data.getIntExtra(SecondActivity.EXTRA_RESULTADO, 0)
                    val boton = when (botonNro) {
                        1 -> "OK!"
                        2 -> "NO ME COPA"
                        3 -> "Y A MI QUE?"
                        else -> null
                    }
                    if (null != boton) {
                        Toast.makeText(
                            this,
                            boton,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show()
        }
    }

    private fun irOtraPantalla() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.EXTRA_DIAGNOSTICO, resultadoImc())
        startActivityForResult(intent, SecondActivity.REQUEST)
    }

    private fun resultadoImc(): String {
        val texto1 = textResultado1.text
        val imc = imcTv.text
        val texto2 = textResultado2.text
        val diagnostico = diagnosticoTv.text

        return "$texto1: $imc. $texto2 $diagnostico."
    }
}

