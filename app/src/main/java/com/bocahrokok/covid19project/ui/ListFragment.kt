package com.bocahrokok.covid19project.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bocahrokok.covid19project.R
import com.bocahrokok.covid19project.database.CovidDatabase


import com.bocahrokok.covid19project.network.CovidCityNetwork
import com.bocahrokok.covid19project.repository.CovidCitiesRepository
import com.bocahrokok.covid19project.ui.Adapter.CovidCityListAdapter

import com.bocahrokok.covid19project.viewmodels.ListViewModel
import com.bocahrokok.covid19project.viewmodels.ListViewModelProviderFactory

import kotlinx.android.synthetic.main.fragment_overview.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment(R.layout.fragment_overview) {


    lateinit var listViewModel: ListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = CovidCitiesRepository(CovidCityNetwork, CovidDatabase.invoke(requireContext()))
        val ListViewModelProviderFactory2 = ListViewModelProviderFactory(repository)
        listViewModel = ViewModelProvider(this, ListViewModelProviderFactory2).get(ListViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
         listViewModel.list.observe(viewLifecycleOwner, Observer {cityList ->
            rv_city_list.also {
                it.layoutManager= LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    CovidCityListAdapter(
                        cityList
                    )
            }
        })
    }

//
}




