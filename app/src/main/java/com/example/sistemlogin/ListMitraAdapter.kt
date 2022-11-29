package com.example.sistemlogin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListMitraAdapter(private val listMitra: ArrayList<Mitra>): RecyclerView.Adapter<ListMitraAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
//    private lateinit var btnMoveDetailActivity: KateringActivity

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvNama: TextView = itemView.findViewById(R.id.tv_item_mitra)
        var tvDesk : TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvLokasi : TextView = itemView.findViewById(R.id.tv_lokasi)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data : Mitra)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_mitra, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val mitra = listMitra[position]

        Glide.with(holder.itemView.context)
            .load(mitra.photo)
            .apply(RequestOptions().override(150, 170))
            .into(holder.imgPhoto)

        holder.tvNama.text = mitra.name
        holder.tvDesk.text = mitra.description
        holder.tvLokasi.text = mitra.location

        holder.itemView.setOnClickListener{ onItemClickCallback.onItemClicked(listMitra[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return listMitra.size
    }
}