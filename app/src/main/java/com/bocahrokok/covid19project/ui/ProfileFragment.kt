package com.bocahrokok.covid19project.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.bocahrokok.covid19project.R
import com.bocahrokok.covid19project.database.CovidDatabase

import com.bocahrokok.covid19project.domain.GridInfo
import com.bocahrokok.covid19project.network.CovidCityNetwork
import com.bocahrokok.covid19project.repository.CovidCitiesRepository
import com.bocahrokok.covid19project.viewmodels.ProfilViewModel
import com.bocahrokok.covid19project.viewmodels.ProfilViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment() : Fragment() {

//    private val viewModel: ProfilViewModel by viewModels { defaultViewModelProviderFactory}

    lateinit var profilViewModel: ProfilViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository =  CovidCitiesRepository(CovidCityNetwork, CovidDatabase.invoke(requireContext()) )
        val ProfilViewModelProviderFactory = ProfilViewModelProviderFactory(repository)

        profilViewModel = ViewModelProvider(this, ProfilViewModelProviderFactory).get(ProfilViewModel::class.java)
//        profilViewModel.gridList()




    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var gridItems: ArrayList<GridInfo> = ArrayList()

        gridItems.add(GridInfo(R.drawable.ic_coronatime, "What is Corona?"))
        gridItems.add(GridInfo(R.drawable.ic_cough, "Gejala"))
        gridItems.add(GridInfo(R.drawable.ic_pencegahan, "Pencegahan"))
        gridItems.add(GridInfo(R.drawable.ic_penyembuhan, "Penyembuhan"))

        rv_grid_list.also {
            it.layoutManager = GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false )
                it.setHasFixedSize(true)
                it.adapter = GridInfoCardAdapter(gridItems!!)
        }

//        profilViewModel.gridListLiveData.observe(viewLifecycleOwner, Observer { list ->
//            rv_grid_list.also {
//                it.layoutManager = GridLayoutManager(requireContext(), 3, LinearLayoutManager.VERTICAL, false )
//                it.setHasFixedSize(true)
//                it.adapter = GridInfoCardAdapter(list!!)
//            }
//        })
    }

    fun setGridInList(): ArrayList<GridInfo> {

        var gridItems: ArrayList<GridInfo> = ArrayList()

            gridItems.add(GridInfo(R.drawable.ic_coronatime, "What is Corona?"))
            gridItems.add(GridInfo(R.drawable.ic_cough, "Gejala"))
            gridItems.add(GridInfo(R.drawable.ic_pencegahan, "Pencegahan"))
            gridItems.add(GridInfo(R.drawable.ic_penyembuhan, "Penyembuhan"))

        return gridItems

    }

}
