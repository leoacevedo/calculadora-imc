package com.leolei.myapplication.lista3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.leolei.myapplication.R
import com.leolei.myapplication.api.Empleado

class EmpleadoAdapter(
    private val context: Context
): RecyclerView.Adapter<EmpleadoViewHolder>() {

    var data: List<Empleado> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /**
     * campo data_field: List<Empleado>

     * fun getData(): List<Empleado> { return data_field }

     * fun setData(value: List<Empleado>) {
         data_field = value
       }
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpleadoViewHolder {
        // Crea una vista
        val vista = LayoutInflater.from(context).inflate(R.layout.layout_empleado, parent, false)

        // Crea un ViewHolder con esa vista
        val viewHolder = EmpleadoViewHolder(vista)

        // Retornar el ViewHolder
        return viewHolder
    }

    override fun onBindViewHolder(holder: EmpleadoViewHolder, position: Int) {
        val empleado = data[position]

        holder.nombreTv.text = empleado.nombre
        holder.edadTv.text = "${empleado.edad} años"
        holder.salarioTv.text = "\$${empleado.salario}"
    }

    override fun getItemCount(): Int {
        return data.size
    }
}


class EmpleadoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val nombreTv: TextView
    val edadTv: TextView
    val salarioTv: TextView

    init {
        nombreTv = itemView.findViewById(R.id.nombre_empleado)
        edadTv = itemView.findViewById(R.id.edad_empleado)
        salarioTv = itemView.findViewById(R.id.salario_empleado)
    }
}