package com.bocahrokok.covid19project.ui

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bocahrokok.covid19project.R
import com.bocahrokok.covid19project.databinding.RvCityBinding
import com.bocahrokok.covid19project.domain.CovidCountryData
import com.bocahrokok.covid19project.util.Utils
import kotlinx.android.synthetic.main.rv_city.view.*


class CovidCityListAdapter(val cityList: List<CovidCountryData>) : RecyclerView.Adapter<CovidCityListAdapter.CityListViewHolder>() {


    inner class CityListViewHolder(val rvCityView: View): RecyclerView.ViewHolder(rvCityView)

    //create the viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityListViewHolder{
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val binding: RvCityBinding = DataBindingUtil.inflate( layoutInflater, R.layout.rv_city, parent, false)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_city, parent, false)
        return CityListViewHolder(view)
    }

    override fun getItemCount() = cityList.size

    //bind the data
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: CityListViewHolder, position: Int) {

           holder.rvCityView.apply {

               txt_location.text = cityList[position].countryRegion
               txt_death.text = "Death: " +  cityList[position].deaths.toString()
               txt_data.text  = "Confirmed: " + cityList[position].confirmed.toString()
               txt_rcv.text = "Recovered: "+  cityList[position].recovered.toString()
//               txt_information.text = "Last Update: " + cityList[position].lastUpdate.toString()
               val date = Utils.formatTime(cityList[position].lastUpdate)
               txt_information.text = "Last Update " + date

           }





//            holder.rvCityBinding.tvConfirmed.text = cityList[position].confirmed.toString()
//            holder.rvCityBinding.tvDeath.text = cityList[position].deaths.toString()
//            holder.rvCityBinding.tvIso.text = cityList[position].iso3.toString()
//            holder.rvCityBinding.tvRegion.text = cityList[position].countryRegion
//            holder.rvCityBinding.tvRecovered.text = cityList[position].recovered.toString()
//            holder.rvCityBinding.tvLastUpdate.text = cityList[position].recovered.toString()

    }
}
