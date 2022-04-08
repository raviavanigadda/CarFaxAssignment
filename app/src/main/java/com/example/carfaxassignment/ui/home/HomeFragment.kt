package com.example.carfaxassignment.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.carfaxassignment.R
import com.example.carfaxassignment.base.BaseFragment
import com.example.carfaxassignment.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject
import com.example.carfaxassignment.data.model.Result

@AndroidEntryPoint
class HomeFragment() : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var vehiclesAdapter: VehiclesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        initViews()

        return binding.root
    }

    private fun initViews() {
        binding.recyclerView.adapter = vehiclesAdapter
        vehiclesAdapter.itemClickListener = {
            findNavController().navigate(
                R.id.action_homeFragment_to_vehicleDetailsFragment,
                bundleOf("_arg_key_vehicle" to it)
            )
        }

        vehiclesAdapter.callButtonClickListener = {
            val intent = Intent(Intent.ACTION_DIAL)

            intent.data = Uri.parse("tel:${it}")
            requireContext().startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        subscribe(
            viewModel.getVehicles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("HomeFragment", "Received UIModel $it vehicles.")
                    showVehicles(it)
                }, {
                    Log.d("HomeFragment", it.message ?: "Error Message")
                    showError()
                })
        )
    }

    fun showVehicles(data: Result) {
        if (data.error == null) {
            //adapter to be used
            vehiclesAdapter.addItem(vehicles = data.vehicles)
        } else if (data.error is ConnectException || data.error is UnknownHostException) {
            Log.d("HomeFragment", "No connection, maybe inform user that data loaded from DB.")
        } else {
            showError()
        }
    }

    fun showError() {
        Toast.makeText(context, "An error occurred :(", Toast.LENGTH_SHORT).show()
    }

    private fun checkArgs() {

    }
}