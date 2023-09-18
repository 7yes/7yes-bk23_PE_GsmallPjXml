package com.jess.gsmallpjxml.ui.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jess.gsmallpjxml.core.load
import com.jess.gsmallpjxml.databinding.ItemSmallBinding
import com.jess.gsmallpjxml.domain.model.MyItem

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSmallBinding.bind(view)
    fun render(item: MyItem) {
        binding.tvTitle.text = item.name
        binding.imPhoto.load(item.photo)
        binding.tvDescription.text = item.description
    }
}