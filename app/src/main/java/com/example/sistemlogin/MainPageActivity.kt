package com.example.sistemlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
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

        listMitraAdapter.setOnItemClickCallback(object : ListMitraAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Mitra) {
                showSelectorMitra(data)
            }
        })
    }

    private fun showSelectorMitra(data: Mitra) {
        Toast.makeText(this, "You choose "+ data.name, Toast.LENGTH_SHORT).show()
        var moveKatering = Intent(this@MainPageActivity, KateringActivity::class.java)

        moveKatering.putExtra(KateringActivity.EXTRA_NAME, data.name)
        moveKatering.putExtra(KateringActivity.EXTRA_PHOTO, data.photo)
        moveKatering.putExtra(KateringActivity.EXTRA_DESKRIPSI, data.description)
        startActivity(moveKatering)
    }

}