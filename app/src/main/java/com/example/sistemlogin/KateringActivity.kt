package com.example.sistemlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KateringActivity : AppCompatActivity() {
    private lateinit var rvMasakan: RecyclerView
    private var list: ArrayList<Masakan> = arrayListOf()

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESKRIPSI = "extra_deskripsi"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_katering)

        rvMasakan = findViewById(R.id.rv_makanan_tersedia)
        rvMasakan.setHasFixedSize(true)

        list.addAll(MasakansData.listData)
        showRecyclerList()

        val tvNamaMitra: TextView = findViewById(R.id.tv_nama_mitra)
        val tvDeskripsiMitra: TextView = findViewById(R.id.tv_item_deskripsi)
        val tvPhotoMitra: ImageView = findViewById(R.id.tv_img_photo_mitra)

        val nama = intent.getStringExtra(EXTRA_NAME)
        val deskripsi = intent.getStringExtra(EXTRA_DESKRIPSI)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        tvNamaMitra.text = nama
        tvDeskripsiMitra.text = deskripsi
        tvPhotoMitra.setImageResource(photo)
    }

    private fun showRecyclerList() {
        rvMasakan.layoutManager = LinearLayoutManager(this)
        val listMitraAdapter = ListMasakanAdapter(list)
        rvMasakan.adapter = listMitraAdapter

    }
}