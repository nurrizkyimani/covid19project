package com.bocahrokok.covid19project.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bocahrokok.covid19project.R
import com.bocahrokok.covid19project.database.CovidDatabase
import com.bocahrokok.covid19project.network.CovidCityNetwork
import com.bocahrokok.covid19project.repository.CovidCitiesRepository
import com.bocahrokok.covid19project.ui.Adapter.NewsCardAdapter

import com.bocahrokok.covid19project.viewmodels.HomeViewModel
import com.bocahrokok.covid19project.viewmodels.HomeViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment() : Fragment() {

    lateinit var homeViewModel: HomeViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository =  CovidCitiesRepository(CovidCityNetwork,CovidDatabase.invoke(requireContext()) )
        val homeViewModelFactory  = HomeViewModelProviderFactory(repository)
        homeViewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        more_detail_click.setOnClickListener {
            val nextAction = HomeFragmentDirections.actionHomeFragmentToNewsFragment()
            Navigation.findNavController(it).navigate(nextAction)
        }

        homeViewModel.newsResponseList.observe(viewLifecycleOwner, Observer { list ->
            rv_home_news_card.also {
                it.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
                it.adapter =
                    NewsCardAdapter(list)
            }
         })


        homeViewModel.indoSumResponse.observe(viewLifecycleOwner, Observer { response ->
            response.body()?.apply {
                tv_recov_text.text = recovered?.value.toString()
            }
            tv_death_text.text =  response.body()?.deaths?.value.toString()
            tv_conf_text.text = response.body()?.confirmed?.value.toString()
        })
    }
}
