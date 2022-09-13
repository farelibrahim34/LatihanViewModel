package com.example.latihanviewmodel

import java.io.Serializable

data class DataBerita(val judul : String, val tanggal : String, val nama : String, val gambar : Int, val isi : String) : Serializable
