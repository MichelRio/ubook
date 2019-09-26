package com.example.lenovo.ubook.Apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Client {
    private const val API_URL = "https://api.themoviedb.org/3/"


    val instance: Movies by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Movies::class.java)
    }
}