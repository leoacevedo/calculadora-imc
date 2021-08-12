package com.leolei.myapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CreadorDeRetrofit {
    fun crearServicioEmpleado(): ServicioEmpleado {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummy.restapiexample.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ServicioEmpleado::class.java)
    }
}