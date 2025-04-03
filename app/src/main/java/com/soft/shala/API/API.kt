package com.soft.shala.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {

    private const val baseUrl=""
    val ApiService:ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java);

    }
}