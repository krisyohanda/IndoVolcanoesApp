package com.example.indovolcanoesapp

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.indovolcanoesapp.network.Volcanoes
import com.example.indovolcanoesapp.ui.VolcanoesApiStatus
import com.example.indovolcanoesapp.ui.VolcanoesListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Volcanoes>?) {
    val adapter = recyclerView.adapter as VolcanoesListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: VolcanoesApiStatus?) {
    when(status) {
        VolcanoesApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_loading_animation)
        }
        VolcanoesApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        VolcanoesApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}