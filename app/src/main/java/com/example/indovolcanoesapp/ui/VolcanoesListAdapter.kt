package com.example.indovolcanoesapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.indovolcanoesapp.databinding.ListViewItemBinding
import com.example.indovolcanoesapp.network.Volcanoes

class VolcanoesListAdapter(val clickListener: VolcanoesListener) :
    ListAdapter<Volcanoes, VolcanoesListAdapter.VolcanoesViewHolder>(DiffCallback) {

    class VolcanoesViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: VolcanoesListener, volcanoes: Volcanoes) {
            binding.volcanoes = volcanoes
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Volcanoes>() {

        override fun areItemsTheSame(oldItem: Volcanoes, newItem: Volcanoes): Boolean {
            return oldItem.nama == newItem.nama
        }

        override fun areContentsTheSame(oldItem: Volcanoes, newItem: Volcanoes): Boolean {
            return oldItem.bentuk == newItem.bentuk && oldItem.tinggi_meter == newItem.tinggi_meter
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VolcanoesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return VolcanoesViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VolcanoesViewHolder, position: Int) {
        val volcanoes = getItem(position)
        holder.bind(clickListener, volcanoes)
    }
}

class VolcanoesListener(val clickListener: (volcanoes: Volcanoes) -> Unit) {
    fun onClick(volcanoes: Volcanoes) = clickListener(volcanoes)
}