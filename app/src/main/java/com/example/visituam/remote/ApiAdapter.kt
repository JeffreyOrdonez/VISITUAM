package com.example.visituam.remote


import com.example.visituam.util.Global
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiAdapter {

    val okHttpClient = OkHttpClient.Builder().build()

    fun getInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(Global.Link_Casa)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}