package com.leolei.myapplication.api

import com.leolei.myapplication.api.ResultadoApi
import retrofit2.Call
import retrofit2.http.GET

interface ServicioEmpleado {
    @GET("api/v1/employees")
    fun obtenerEmpleados(): Call<ResultadoApi>
}