package com.example.carfaxassignment.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.carfaxassignment.R
import com.example.carfaxassignment.databinding.FragmentVehicleDetailsBinding
import com.example.carfaxassignment.model.Vehicle


class VehicleDetailsFragment() : Fragment() {

    lateinit var binding: FragmentVehicleDetailsBinding
    private var vehicle: Vehicle? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_vehicle_details, container, false)

        getArg()

        return binding.root
    }

    private fun initViews() {
    }

    private fun getArg() {
        arguments?.let {
            if (it.containsKey(ARG_KEY_VEHICLE)) {
                vehicle = it.getParcelable(ARG_KEY_VEHICLE)!!
                binding.vehicle = vehicle
            }
        }
    }

    companion object {
        const val ARG_KEY_VEHICLE = "_arg_key_vehicle"
    }
}