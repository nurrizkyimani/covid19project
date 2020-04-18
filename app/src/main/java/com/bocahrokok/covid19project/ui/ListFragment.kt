package com.bocahrokok.covid19project.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bocahrokok.covid19project.CovidCityListAdapter
import com.bocahrokok.covid19project.R


import com.bocahrokok.covid19project.databinding.FragmentOverviewBinding
import com.bocahrokok.covid19project.viewmodels.DevCovViewModel
import kotlinx.android.synthetic.main.fragment_overview.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment(R.layout.fragment_overview) {

    private lateinit var binding: FragmentOverviewBinding
    private lateinit var viewModel2: DevCovViewModel
    private lateinit var adapter: CovidCityListAdapter

    //biding utl

    private val viewModel: DevCovViewModel by viewModels { defaultViewModelProviderFactory}

    fun showData(){
        viewModel.data.observe(this, Observer {
            Toast.makeText(context, it.size.toString(), Toast.LENGTH_LONG)
        })
    }

    fun showDatafromRoom(){
        viewModel.list.observe(this, Observer {
            Toast.makeText(context, it.size.toString(), Toast.LENGTH_LONG)
        })
    }

    fun showDataDailyfromRoom(){
        viewModel.listDaily.observe(this, Observer {
//            helloWorldText.text = it.size.toString()
            Toast.makeText(context, it.size.toString(), Toast.LENGTH_LONG)
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
                it.adapter =
                    CovidCityListAdapter(cityList)
            }
        })
    }

//
}




