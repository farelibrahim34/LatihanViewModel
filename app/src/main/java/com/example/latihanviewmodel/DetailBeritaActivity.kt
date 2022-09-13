package com.example.latihanviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_detail_berita.*
import kotlinx.android.synthetic.main.item_berita.*

class DetailBeritaActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)




        var getDataDetail = intent.getSerializableExtra("detailberita") as DataBerita
        imgDetail.setImageResource(getDataDetail.gambar)
        txtJudulDetail.text = getDataDetail.judul
        txtJurnalisDetail.text = getDataDetail.nama
        txtTglDetail.text = getDataDetail.tanggal
        txtIsi.text = getDataDetail.isi

    }
}