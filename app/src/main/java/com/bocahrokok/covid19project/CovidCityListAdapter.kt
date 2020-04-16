package com.bocahrokok.covid19project

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bocahrokok.covid19project.databinding.RvCityBinding
import com.bocahrokok.covid19project.network.NetworkCovidData
import kotlin.coroutines.coroutineContext

class CovidCityListAdapter(val cityList: List<NetworkCovidData>) : RecyclerView.Adapter<CovidCityListAdapter.CityListViewHolder>() {


    inner class CityListViewHolder(val rvCityBinding: RvCityBinding): RecyclerView.ViewHolder(rvCityBinding.root)

    //create the viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  CityListViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.rv_city,
            parent,
            false

        ))


    override fun getItemCount() = cityList.size

    //bind the data
    override fun onBindViewHolder(holder: CityListViewHolder, position: Int) {
//            holder.rvCityBinding.list = cityList[position]
            holder.rvCityBinding.tvConfirmed.text = cityList[position].confirmed.toString()
            holder.rvCityBinding.tvDeath.text = cityList[position].deaths.toString()
            holder.rvCityBinding.tvIso.text = cityList[position].iso3.toString()
            holder.rvCityBinding.tvRegion.text = cityList[position].countryRegion
            holder.rvCityBinding.tvRecovered.text = cityList[position].recovered.toString()
            holder.rvCityBinding.tvLastUpdate.text = cityList[position].recovered.toString()

    }
}
