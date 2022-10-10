package com.example.viajes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viajes.databinding.LugarItemBinding

class lugarAdapter(val lugares: List<Lugar>, val listener: (Lugar) -> Unit) : RecyclerView.Adapter<lugarAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lugar_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lugares[position])

        holder.itemView.setOnClickListener{
            listener(lugares[position])
        }
    }

    override fun getItemCount(): Int = lugares.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        private val binding = LugarItemBinding.bind(view)

        fun bind(lugar : Lugar){
            Glide.with(binding.ivFoto).load(lugar.img).into(binding.ivFoto)
            binding.tvNombre.text = lugar.nombre
        }
    }
}