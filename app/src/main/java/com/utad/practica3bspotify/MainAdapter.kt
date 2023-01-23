package com.utad.practica3bspotify

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter (private val mDataSet: List<playlists>, var onClick: (playlists) -> Unit) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        //Item block es el laayout donde estara la lista
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_block, parent, false)
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
        //mytexto = text view de itemblock
        val mytexto = v.findViewById<TextView>(R.id.mytexto)
        val mytexto1 = v.findViewById<TextView>(R.id.mytexto1)
        val myImageview = v.findViewById<ImageView>(R.id.imagenCeldas)
        val seguidores = v.findViewById<TextView>(R.id.seguidores)

        fun bindItems(data: playlists) {
            mytexto1.text = data.name + " " + data.surname
            seguidores.text = data.seguidores
            Glide.with(myImageview.context).load(data.foto).into(myImageview)
        }
    }


}