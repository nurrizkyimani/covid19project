package com.bocahrokok.covid19project.ui

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bocahrokok.covid19project.R
import com.bocahrokok.covid19project.database.getDatabase
import com.bocahrokok.covid19project.network.CovidCityNetwork
import com.bocahrokok.covid19project.repository.CovidCitiesRepository
import com.bocahrokok.covid19project.viewmodels.DevCovViewModel
import com.bocahrokok.covid19project.viewmodels.HomeViewModel
import com.bocahrokok.covid19project.viewmodels.HomeViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment() : Fragment() {

    lateinit var homeViewModel: HomeViewModel


//    private val homeViewModel: HomeViewModel by viewModels {  defaultViewModelProviderFactory }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = CovidCitiesRepository(CovidCityNetwork, getDatabase(this.requireContext()))
        val homeViewModelFactory  = HomeViewModelProviderFactory(repository)
        homeViewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)




        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

//        showNewsData()
//            showNewsResponse()



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
        homeViewModel.newsResponseList.observe(viewLifecycleOwner, Observer { list ->
            rv_home_news_card.also {
                it.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
                it.adapter = NewsCardAdapter(list)
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



//    fun showNewsResponse(){
////        homeViewModel.newsReponse.observe(this, Observer { response ->
////            tv_home_testing.text =  response.body()?.articles.toString()
////        }
//
//
//            Toast.makeText(context,"Fetch done", Toast.LENGTH_LONG).show()
//
//        )
//    }


//    fun showNewsData(){
//        homeViewModel.newsList.observe(this, Observer {
//            Toast.makeText(context, it.toString(), Toast.LENGTH_LONG)
//            tv_home_testing.text = it.toString()
//        })
//
//    }

    //    fun showData(){
//        viewModel.data.observe(this, Observer {
//            Toast.makeText(context, it.size.toString(), Toast.LENGTH_LONG)
////            tv_home_testing.text = it.toString()
//        })
//    }
//
//    fun showDatafromRoom(){
//        viewModel.list.observe(this, Observer {
//            Toast.makeText(context, it.size.toString(), Toast.LENGTH_LONG)
//        })
//    }
//
//    fun showDataDailyfromRoom(){
//        viewModel.listDaily.observe(this, Observer {
//            Toast.makeText(context, it.size.toString(), Toast.LENGTH_LONG)
////            tv_home_testing.text = it.toString()
//        })
//    }


}
