package com.example.notbored.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    const val URL="http://www.boredapi.com/api/"
    fun getRetrofit():Retrofit{
    return Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}