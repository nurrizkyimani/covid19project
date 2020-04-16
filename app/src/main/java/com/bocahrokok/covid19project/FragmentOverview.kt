package com.bocahrokok.covid19project

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager


import com.bocahrokok.covid19project.databinding.FragmentOverviewBinding
import com.bocahrokok.covid19project.network.NetworkCovidData
import com.bocahrokok.covid19project.viewmodels.DevCovViewModel
import kotlinx.android.synthetic.main.fragment_overview.*
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class FragmentOverview : Fragment(R.layout.fragment_overview) {

    private lateinit var binding: FragmentOverviewBinding
    private lateinit var viewModel2: DevCovViewModel
    private lateinit var adapter: CovidCityListAdapter

    //biding utl

    private val viewModel: DevCovViewModel by viewModels { defaultViewModelProviderFactory}

    fun showData(){
        viewModel.data.observe(this, Observer {
            tv_testing.text = it.toString()
        })
    }

    fun showDatafromRoom(){
        viewModel.list.observe(this, Observer {
            tv_testing.text = it.size.toString()
        })
    }

    fun showDataDailyfromRoom(){
        viewModel.listDaily.observe(this, Observer {
//            helloWorldText.text = it.size.toString()
            tv_testing.text = it.toString()
        })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        showData()
//        showDatafromRoom()
//        showDataDailyfromRoom()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//
        binding = FragmentOverviewBinding.inflate(inflater, container, false)
//      binding.viewModel = viewModel

        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
         viewModel.list.observe(viewLifecycleOwner, Observer {cityList ->
            rv_city_list.also {
                it.layoutManager= LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = CovidCityListAdapter(cityList)
            }
        })
    }

//
}




