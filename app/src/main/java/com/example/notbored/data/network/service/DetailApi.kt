package com.example.notbored.data.network.service

import com.example.notbored.data.model.DetailModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DetailApi {
    //aca van loos get y request de la api

    //url print

    @GET("activity?")
    fun getActivityDetaill(
        @Query("type",encoded = true) type: String,
        @Query("participants",encoded = true) participants: String

    ): Call<DetailModel>

    @GET("activity/")
    fun getActivityDetaillRandom(
        )  : Call<DetailModel>
}