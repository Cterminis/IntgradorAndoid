package com.example.notbored.data.service

import retrofit2.http.GET
import retrofit2.http.Query

interface DetailApi {
    //aca van loos get y request de la api

    @GET("activity?type={type}&participants={participants}")
    fun getActivityDetaill(
        @Query("type") type: String,
        @Query("participants") participants: String,
    )
}