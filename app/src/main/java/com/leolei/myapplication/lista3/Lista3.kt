package com.leolei.myapplication.lista3

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.leolei.myapplication.R
import com.leolei.myapplication.api.CreadorDeRetrofit
import com.leolei.myapplication.api.ResultadoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Lista3 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EmpleadoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_3)

        recyclerView = findViewById(R.id.lista)
        adapter = EmpleadoAdapter(this)
        recyclerView.adapter = adapter

        val creador = CreadorDeRetrofit()
        creador.crearServicioEmpleado().obtenerEmpleados().enqueue(object : Callback<ResultadoApi> {
            override fun onResponse(call: Call<ResultadoApi>, response: Response<ResultadoApi>) {
                if (response.isSuccessful) {
                    mostrarResultados(response.body())
                } else {
                    Toast.makeText(this@Lista3, "Hubo un error, despues me fijo", Toast.LENGTH_LONG).show()
                    Log.e("ERROR", response.errorBody()?.string() ?: "errorBody == null, no se que pasa pero pasa algo")
                }
            }

            override fun onFailure(call: Call<ResultadoApi>, t: Throwable) {
                Toast.makeText(this@Lista3, t.message, Toast.LENGTH_LONG).show()
                t.printStackTrace()
            }
        })
    }

    private fun mostrarResultados(body: ResultadoApi?) {
        if (body != null) {
            adapter.data = body.data
        } else {
            Toast.makeText(this, "Epa, los resultaods vienen nulos", Toast.LENGTH_LONG).show()
        }
    }

}