package com.leolei.myapplication.lista3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.leolei.myapplication.R
import com.leolei.myapplication.api.ResultadoApi

class EjemploRetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_retrofit)

//        val contenido = findViewById<RecyclerView>(R.id.lista)
//        contenido.adapter = EmpleadoAdapter()
//
//        val creador = CreadorDeRetrofit()
//        creador.crearServicioEmpleado().obtenerEmpleados().enqueue(object : Callback<ResultadoApi> {
//            override fun onResponse(call: Call<ResultadoApi>, response: Response<ResultadoApi>) {
//                if (response.isSuccessful) {
//                    val respuesta = response.body()
//                    if (respuesta != null) {
//                        contenido.text = respuestaTextual(respuesta)
//                    }
//                } else {
//                    contenido.text = response.errorBody()?.string()
//                }
//            }
//
//            override fun onFailure(call: Call<ResultadoApi>, t: Throwable) {
//                contenido.text = t.message
//                t.printStackTrace()
//            }
//        })
    }

    private fun respuestaTextual(resultadoApi: ResultadoApi): String {
        var resultado: String = ""
        for (empleado in resultadoApi.data) {
            resultado += "${empleado.nombre}, ${empleado.edad} años\n"
        }
        return resultado
    }
}