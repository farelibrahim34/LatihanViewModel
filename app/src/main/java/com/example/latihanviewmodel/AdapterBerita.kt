package com.example.latihanviewmodel

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class AdapterBerita(var listBerita : ArrayList<DataBerita>): RecyclerView.Adapter<AdapterBerita.ViewHolder>() {

    var onClick :((DataBerita)-> Unit)? = null

    class ViewHolder(view : View): RecyclerView.ViewHolder(view) {
        var judul = view.findViewById<TextView>(R.id.txtJudul)
        var tanggal = view.findViewById<TextView>(R.id.txtTgl)
        var namaJurnalis = view.findViewById<TextView>(R.id.txtJurnalis)
        var image = view.findViewById<ImageView>(R.id.imgBerita)
        var card =view.findViewById<CardView>(R.id.cardList)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =LayoutInflater.from(parent.context)
            .inflate(R.layout.item_berita, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.judul.text = listBerita[position].judul
        holder.image.setImageResource(listBerita[position].gambar)
        holder.tanggal.text = listBerita[position].tanggal
        holder.namaJurnalis.text = listBerita[position].nama


        holder.card.setOnClickListener {
            onClick?.invoke(listBerita[position])
        }
    }

    override fun getItemCount(): Int {
        return listBerita.size
    }

    fun setDataBerita(listberita: ArrayList<DataBerita>){
        this.listBerita = listberita

    }

}