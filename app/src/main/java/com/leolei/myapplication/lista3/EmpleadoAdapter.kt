package com.leolei.myapplication

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leolei.myapplication.api.Empleado

class EmpleadoAdapter(val data: List<Empleado>): RecyclerView.Adapter<EmpleadoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpleadoViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: EmpleadoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return data.size
    }

}


class EmpleadoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

}