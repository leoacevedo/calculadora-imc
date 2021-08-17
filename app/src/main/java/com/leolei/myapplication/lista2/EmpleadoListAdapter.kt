package com.leolei.myapplication.lista2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.leolei.myapplication.R
import com.leolei.myapplication.api.Empleado

class EmpleadoListAdapter(context: Context): ArrayAdapter<Empleado>(context, R.layout.layout_empleado) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val vistaEmpleado: View
        val viewHolder: EmpleadoViewHolder

        if (convertView == null) {
            vistaEmpleado = LayoutInflater.from(context).inflate(R.layout.layout_empleado, parent, false)
            viewHolder = EmpleadoViewHolder(vistaEmpleado)
            vistaEmpleado.tag = viewHolder
        } else {
            vistaEmpleado = convertView
            viewHolder = convertView.tag as EmpleadoViewHolder
        }

        val empleado = getItem(position)
        if (empleado != null) {
            viewHolder.nombreTv.text = empleado.nombre
            viewHolder.edadTv.text = "${empleado.edad} años"
            viewHolder.salarioTv.text = "\$${empleado.salario}"
        }

        return vistaEmpleado
    }

    override fun getCount(): Int {
        return super.getCount()
    }
}

class EmpleadoViewHolder(vista: View) {
    val nombreTv: TextView
    val edadTv: TextView
    val salarioTv: TextView

    init {
        nombreTv = vista.findViewById(R.id.nombre_empleado)
        edadTv = vista.findViewById(R.id.edad_empleado)
        salarioTv = vista.findViewById(R.id.salario_empleado)
    }
}