package com.utad.practica3bspotify

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Main2Adapter (private val mDataSet: List<cancion>, var onClick: (cancion) -> Unit) : RecyclerView.Adapter<Main2Adapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        //Item block es el laayout donde estara la lista
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_block2, parent, false)
        return MainViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = mDataSet.get(position)
        holder.bindItems(data)
        //Cuando alguien pulsa una fila de la lista se pasa el onClick al mainActivity
        holder.itemView.setOnClickListener(){
            onClick(data)
        }
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    inner class MainViewHolder(var v: View) : RecyclerView.ViewHolder(v) {
       //view de itemblock2
        val mytextoCancion = v.findViewById<TextView>(R.id.mytexto1Cancion)
        val mytexto1Autor = v.findViewById<TextView>(R.id.mytexto1Autor)
        val myImageviewCancion = v.findViewById<ImageView>(R.id.imagenCeldaCancion)
        val corazonVacio = v.findViewById<CheckBox>(R.id.corazon)



        fun bindItems(data: cancion) {
            mytextoCancion.text = data.titulo
            mytexto1Autor.text = data.autor
            Glide.with(myImageviewCancion.context).load(data.url).into(myImageviewCancion)
            corazonVacio.setOnClickListener {
                if (corazonVacio.isChecked) {
                    corazonVacio.setBackgroundResource(R.drawable.ic_corazonlleno)
                } else {
                    corazonVacio.setBackgroundResource(R.drawable.ic_corazonsinrelleno)
                }
            }
        }

    }



}