package com.leolei.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        val EXTRA_RESULTADO = "RESULTADO"
        val EXTRA_DIAGNOSTICO = "DIAGNOSTICO"

        val REQUEST = 8182
        val BTN_OK = 1
        val BTN_NO_ME_GUSTA = 2
        val BTN_NO_ME_INTERESA = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val resultado = intent.getStringExtra(EXTRA_DIAGNOSTICO)

        val texto: TextView = findViewById(R.id.texto)
        texto.text = resultado

        val ok : Button = findViewById(R.id.ok)
        val noMeGusta : Button = findViewById(R.id.no_me_gusta)
        val noMeInteresa : Button = findViewById(R.id.no_me_interesa)

        ok.setOnClickListener(this)
        noMeGusta.setOnClickListener(this)
        noMeInteresa.setOnClickListener(this)
    }

    private fun devolverResultado(boton: Int) {
        val data = Intent()
        data.putExtra(EXTRA_RESULTADO, boton)
        setResult(RESULT_OK, data)
        finish()
    }

    override fun onClick(v: View?) {
        val boton = when (v?.id) {
            R.id.ok -> BTN_OK
            R.id.no_me_gusta -> BTN_NO_ME_GUSTA
            R.id.no_me_interesa -> BTN_NO_ME_INTERESA
            else -> -1
        }
        if (boton != -1) {
            devolverResultado(boton)
        }
    }

    override fun onBackPressed() {
        setResult(RESULT_CANCELED)
        super.onBackPressed()
    }
}
