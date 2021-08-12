package com.leolei.myapplication.lista2

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.leolei.myapplication.R
import com.leolei.myapplication.api.CreadorDeRetrofit
import com.leolei.myapplication.api.Empleado
import com.leolei.myapplication.api.ResultadoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Ejemplo de lista de elementos 2: ListView + ListAdapter + Class que hereda de View
 * Proximo paso: View Holders
 */
class Lista2 : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: EmpleadoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista2)

        listView = findViewById(R.id.lista_empleados)
        adapter = EmpleadoListAdapter(this)
        listView.adapter = adapter

        val creador = CreadorDeRetrofit()
        creador.crearServicioEmpleado().obtenerEmpleados().enqueue(object : Callback<ResultadoApi> {

            override fun onResponse(call: Call<ResultadoApi>, response: Response<ResultadoApi>) {
                if (response.isSuccessful) {
                    val respuesta = response.body()
                    if (respuesta != null) {
                        mostrarEmpleados(respuesta.data)
                    }
                } else {
                    Toast.makeText(this@Lista2, "Hubo un error, despues me fijo", Toast.LENGTH_LONG).show()
                    // no fue exitosa
                }
            }

            override fun onFailure(call: Call<ResultadoApi>, t: Throwable) {
                Toast.makeText(this@Lista2, t.message, Toast.LENGTH_LONG).show()
                t.printStackTrace()
            }
        })
    }

    private fun mostrarEmpleados(empleados: List<Empleado>) {
        adapter.clear()
        adapter.addAll(empleados)
    }
}