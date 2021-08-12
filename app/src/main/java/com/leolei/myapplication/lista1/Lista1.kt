package com.leolei.myapplication.lista1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.leolei.myapplication.R
import com.leolei.myapplication.api.CreadorDeRetrofit
import com.leolei.myapplication.api.Empleado
import com.leolei.myapplication.api.ResultadoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Ejemplo de lista de elementos 1: crear una vista para cada Empleado
 */
class Lista1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista1)

        val creador = CreadorDeRetrofit()
        creador.crearServicioEmpleado().obtenerEmpleados().enqueue(object : Callback<ResultadoApi> {

            override fun onResponse(call: Call<ResultadoApi>, response: Response<ResultadoApi>) {
                if (response.isSuccessful) {
                    val respuesta = response.body()
                    if (respuesta != null) {
                        mostrarEmpleados(respuesta.data)
                    }
                } else {
                    Toast.makeText(this@Lista1, "Hubo un error, despues me fijo", Toast.LENGTH_LONG).show()
                    // no fue exitosa
                }
            }

            override fun onFailure(call: Call<ResultadoApi>, t: Throwable) {
                Toast.makeText(this@Lista1, t.message, Toast.LENGTH_LONG).show()
                t.printStackTrace()
            }
        })
    }

    private fun mostrarEmpleados(empleados: List<Empleado>) {
        val listaEmpleados = findViewById<LinearLayout>(R.id.lista_empleados)
        val inflador = LayoutInflater.from(this)

        for (empleado in empleados) {

            val vistaEmpleado = inflador.inflate(R.layout.layout_empleado, listaEmpleados, false)

            val nombreTv = vistaEmpleado.findViewById<TextView>(R.id.nombre_empleado)
            val edadTv = vistaEmpleado.findViewById<TextView>(R.id.edad_empleado)
            val salarioTv = vistaEmpleado.findViewById<TextView>(R.id.salario_empleado)

            nombreTv.text = empleado.nombre
            edadTv.text = "${empleado.edad} años"
            salarioTv.text = "\$${empleado.salario}"

            listaEmpleados.addView(vistaEmpleado)
        }
    }
}