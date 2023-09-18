package com.jess.gsmallpjxml.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jess.gsmallpjxml.R
import com.jess.gsmallpjxml.domain.model.MyItem

class ItemAdapter(private val lista: List<MyItem>, private var onClickListener: (MyItem) -> Unit) :
    RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_small, parent, false)
        )
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.render(lista[position], onClickListener)
    }
}