package com.abdulazis.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdulazis.recyclerview.databinding.ListItemFilmBinding
import com.abdulazis.recyclerview.model.Film

class AdapterFilm(private val context: Context,
                  private val data : List<Film>?,
                  private val itemclick : OnClickListener)
                  : RecyclerView.Adapter<AdapterFilm.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFilm.ViewHolder {
        val binding = ListItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterFilm.ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener {
            itemclick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?:0


    inner class ViewHolder(val binding: ListItemFilmBinding): RecyclerView.ViewHolder(binding.root) {
        val foto = binding.image
        val nama = binding.txtnama

    }
    interface OnClickListener {
        fun detailData(item: Film?)
    }
}