package com.leolei.myapplication.api

import com.google.gson.annotations.SerializedName

class ResultadoApi {
    var status: String = ""
    var message: String = ""

    var data: List<Empleado> = emptyList()
}

class Empleado {
    var id: Int = -1

    @SerializedName("employee_name")
    var nombre: String = ""

    @SerializedName("employee_salary")
    var salario: Int = 0

    @SerializedName("employee_age")
    var edad: Int = 0

    @SerializedName("profile_image")
    var foto: String = ""
}