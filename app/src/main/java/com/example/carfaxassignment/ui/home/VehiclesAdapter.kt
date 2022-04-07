package com.android.carfax.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.carfax.R
import com.android.carfax.databinding.ItemVehicleBinding
import com.android.carfax.model.Vehicle
import javax.inject.Inject


class VehiclesAdapter @Inject constructor() :
    RecyclerView.Adapter<VehiclesAdapter.VehiclesViewHolder>() {

    private var vehicles = emptyList<Vehicle>()

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(vehicles: List<Vehicle>) {
        this.vehicles = vehicles
        notifyDataSetChanged()
    }

    internal var clickListener: (Vehicle) -> Unit = { _-> }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesViewHolder =
        VehiclesViewHolder.from(parent, R.layout.item_vehicle)

    override fun getItemCount() = vehicles.size


    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: VehiclesViewHolder, position: Int) {
        holder.binding.apply {
            vehicle = vehicles[position]
            executePendingBindings()

            cardView.setOnClickListener { clickListener(vehicles[position]) }

        }
    }

    class VehiclesViewHolder(val binding: ItemVehicleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup, layout: Int): VehiclesViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding =
                    DataBindingUtil.inflate<ItemVehicleBinding>(
                        inflater,
                        layout,
                        parent,
                        false
                    )
                return VehiclesViewHolder(binding)
            }
        }

    }
}
