package com.example.carfaxassignment.util

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.carfaxassignment.R

@BindingAdapter("loadImageFromUrl")
fun loadImageFromUrl(view: ImageView, url: String) {

    Glide.with(view.context)
        .load(url).apply(RequestOptions().fitCenter())
        .placeholder(R.drawable.car_place_holder)
        .into(view)
}

@SuppressLint("SetTextI18n")
@BindingAdapter("formatMileage")
fun TextView.formatMileage(value: Int) {
    text = "${value/1000f}k mi"
}
