package com.example.sistemlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainPageActivity : AppCompatActivity() {
    private lateinit var rvMitras: RecyclerView
    private var list: ArrayList<Mitra> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        rvMitras = findViewById(R.id.rv_mitras)
        rvMitras.setHasFixedSize(true)

        list.addAll(MitrasData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMitras.layoutManager = LinearLayoutManager(this)
        val listMitraAdapter = ListMitraAdapter(list)
        rvMitras.adapter = listMitraAdapter

    }
}