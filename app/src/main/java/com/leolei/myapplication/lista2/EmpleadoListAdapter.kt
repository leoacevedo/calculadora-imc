package com.leolei.myapplication.lista2

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.leolei.myapplication.R
import com.leolei.myapplication.api.Empleado

class EmpleadoListAdapter(context: Context): ArrayAdapter<Empleado>(context, R.layout.layout_empleado) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val vistaEmpleado: VistaEmpleado

        if (convertView == null) {
            vistaEmpleado = VistaEmpleado(context)
        } else {
            vistaEmpleado = convertView as VistaEmpleado
        }

        val empleado = getItem(position)
        if (empleado != null) {
            vistaEmpleado.nombreTv.text = empleado.nombre
            vistaEmpleado.edadTv.text = "${empleado.edad} años"
            vistaEmpleado.salarioTv.text = "\$${empleado.salario}"
        }

        return vistaEmpleado
    }
}

class VistaEmpleado(context: Context): ConstraintLayout(context) {
    val nombreTv: TextView
    val edadTv: TextView
    val salarioTv: TextView

    init {
        inflate(context, R.layout.layout_empleado, this)

        nombreTv = findViewById(R.id.nombre_empleado)
        edadTv = findViewById(R.id.edad_empleado)
        salarioTv = findViewById(R.id.salario_empleado)

        // desventaja: usar merge hace que se ignoren los paddings y cualquier otra cosa que hayamos puesto en el <merge>
        // solucion: View Holders
        val paddingHorizontal = resources.getDimensionPixelSize(R.dimen.empleado_padding_horizontal)
        val paddingVertical = resources.getDimensionPixelSize(R.dimen.empleado_padding_vertical)

        setPadding(paddingHorizontal, paddingVertical, paddingHorizontal, paddingVertical)
    }
}
