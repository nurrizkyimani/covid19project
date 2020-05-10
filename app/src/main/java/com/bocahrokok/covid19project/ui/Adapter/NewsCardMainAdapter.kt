package com.bocahrokok.covid19project.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bocahrokok.covid19project.R
import com.bocahrokok.covid19project.domain.News.Article
import kotlinx.android.synthetic.main.news_card.view.*
import kotlinx.android.synthetic.main.news_card_main.view.*

class NewsCardMainAdapter(val newsList: List<Article>): RecyclerView.Adapter<NewsCardMainAdapter.NewsCardMainViewHolder>() {

    inner class NewsCardMainViewHolder(val newsCardMainView: View): RecyclerView.ViewHolder(newsCardMainView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsCardMainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_card_main, parent, false)

        return NewsCardMainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsCardMainAdapter.NewsCardMainViewHolder, position: Int) {
        holder.newsCardMainView.apply {
            tv_title_news_main.text = newsList[position].title
            tv_desc_news_main.text = newsList[position].description
        }
    }
}