package com.bocahrokok.covid19project.network

import com.bocahrokok.covid19project.util.Constant
import com.bocahrokok.covid19project.util.Constant.Companion.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NewsInstance {
    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

        }

        val instance by lazy {
            retrofit.create(NewsApi::class.java)
        }

        private val retrofitNewsResponse by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }

        val instanceNewsReponse by lazy {
            retrofitNewsResponse.create(NewsApi::class.java)
        }

    }

}