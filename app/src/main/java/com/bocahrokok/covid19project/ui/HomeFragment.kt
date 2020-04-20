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
import com.bocahrokok.covid19project.R
import com.bocahrokok.covid19project.viewmodels.DevCovViewModel
import com.bocahrokok.covid19project.viewmodels.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {


    private val listViewModel: DevCovViewModel by viewModels { defaultViewModelProviderFactory}
    private val homeViewModel: HomeViewModel by viewModels {  defaultViewModelProviderFactory }

    fun showNewsData(){
        homeViewModel.newsList.observe(this, Observer {
            Toast.makeText(context, it.toString(), Toast.LENGTH_LONG)
            tv_home_testing.text = it.toString()
        })

    }


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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showNewsData()


        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}
