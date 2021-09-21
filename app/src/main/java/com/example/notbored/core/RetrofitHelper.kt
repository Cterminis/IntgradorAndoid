package com.example.notbored.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit():Retrofit{
    return Retrofit.Builder().baseUrl("http://www.boredapi.com/api/").addConverterFactory(GsonConverterFactory.create()).build()
    }
}