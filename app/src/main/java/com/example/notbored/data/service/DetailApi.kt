package com.example.notbored.data.service

import com.example.notbored.data.model.DetailModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.security.auth.login.LoginException

interface DetailApi {
    //aca van loos get y request de la api

    @GET("api/activity?")
    fun getActivityDetaill(
        @Query("type") type: String,
        @Query("participants") participants: String

    ): Call<DetailModel>

    @GET("api/activity/")
    fun getActivityDetaillEx(
        )  : Call<DetailModel>
}