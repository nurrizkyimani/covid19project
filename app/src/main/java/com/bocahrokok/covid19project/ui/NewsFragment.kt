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
import com.bocahrokok.covid19project.ui.Adapter.NewsCardAdapter
import com.bocahrokok.covid19project.ui.Adapter.NewsCardMainAdapter
import com.bocahrokok.covid19project.viewmodels.HomeViewModel
import com.bocahrokok.covid19project.viewmodels.HomeViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_news.*

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment() {

    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository =  CovidCitiesRepository(CovidCityNetwork, CovidDatabase.invoke(requireContext()) )
        val homeViewModelFactory  = HomeViewModelProviderFactory(repository)
        homeViewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        homeViewModel.newsResponseList.observe(viewLifecycleOwner, Observer { list ->
            rv_news_main.also {
                it.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                it.setHasFixedSize(true)
                it.adapter =
                    NewsCardMainAdapter(list)
            }
        })
    }

}
