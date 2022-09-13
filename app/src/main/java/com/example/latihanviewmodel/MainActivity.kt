package com.example.latihanviewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    lateinit var rvBerita : RecyclerView
    lateinit var adapterBerita :AdapterBerita
    lateinit var beritaVm : BeritaViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataBerita()


        beritaVm =ViewModelProvider(this).get(BeritaViewModel::class.java)

        beritaVm.getBerita()
        beritaVm.listberita.observe(this,{
            adapterBerita.setDataBerita(it as ArrayList<DataBerita>)
        })


        adapterBerita.onClick = {
            val pindah = Intent(this,DetailBeritaActivity::class.java)
            pindah.putExtra("detailberita",it)
            startActivity(pindah)
        }



    }
    fun dataBerita(){

        rvBerita = findViewById(R.id.rvBerita)
        adapterBerita = AdapterBerita(ArrayList())

        rvBerita.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvBerita.adapter =adapterBerita
    }
}