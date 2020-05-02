package com.bocahrokok.covid19project.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bocahrokok.covid19project.R
import com.bocahrokok.covid19project.domain.GridInfo
import kotlinx.android.synthetic.main.grid_list_item.view.*

class GridInfoCardAdapter(val gridList: List<GridInfo>): RecyclerView.Adapter<GridInfoCardAdapter.GridInfoViewHolder>() {


    class GridInfoViewHolder(val gridInfoView: View) : RecyclerView.ViewHolder(gridInfoView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
        return GridInfoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gridList.size
    }

    override fun onBindViewHolder(holder: GridInfoViewHolder, position: Int) {
        holder.gridInfoView.apply {
            img_ilus.setImageResource(gridList[position].iconGrid!!)
            tv_ilus.text = gridList[position].titleGrid

        }

    }


}