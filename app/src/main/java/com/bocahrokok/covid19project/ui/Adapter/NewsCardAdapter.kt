package com.bocahrokok.covid19project.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bocahrokok.covid19project.R
import com.bocahrokok.covid19project.domain.News.Article
import kotlinx.android.synthetic.main.news_card.view.*

class NewsCardAdapter(val newsList: List<Article>): RecyclerView.Adapter<NewsCardAdapter.NewsCardViewHolder>() {

    inner class NewsCardViewHolder(val newsCardView: View): RecyclerView.ViewHolder(newsCardView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_card, parent, false)
        return NewsCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsCardViewHolder, position: Int) {
        holder.newsCardView.apply {
            tv_title.text = newsList[position].title
            tv_desc.text = newsList[position].description
        }
    }


}


