package com.alwan.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alwan.core.databinding.ItemBarangBinding
import com.alwan.core.domain.model.Barang
import com.alwan.core.util.loadImage
import com.alwan.core.util.toIDRString

class BarangAdapter(private val onBarangClicked: (com.alwan.core.domain.model.Barang) -> Unit) :
    ListAdapter<com.alwan.core.domain.model.Barang, BarangAdapter.BarangViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BarangViewHolder(
        ItemBarangBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: BarangViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BarangViewHolder(private val binding: ItemBarangBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(barang: com.alwan.core.domain.model.Barang) = binding.apply {
            sivBarang.loadImage(barang.imageUrl)
            tvBarang.text = barang.name
            tvKode.text = barang.code
            tvHarga.text = barang.price.toIDRString()
            root.setOnClickListener { onBarangClicked.invoke(barang) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<com.alwan.core.domain.model.Barang>() {
            override fun areItemsTheSame(
                oldItem: com.alwan.core.domain.model.Barang,
                newItem: com.alwan.core.domain.model.Barang
            ): Boolean {
                return oldItem.code == newItem.code
            }

            override fun areContentsTheSame(
                oldItem: com.alwan.core.domain.model.Barang,
                newItem: com.alwan.core.domain.model.Barang
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}