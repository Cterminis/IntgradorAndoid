package com.example.notbored.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notbored.core.RetrofitHelper.getRetrofit
import com.example.notbored.data.model.DetailModel
import com.example.notbored.data.model.ErrorModel
import com.example.notbored.data.service.DetailApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainViewModel : ViewModel() {

    val isLoadingProgressBar = MutableLiveData<Boolean>()
    val detailActivity = MutableLiveData<DetailModel>()
    val errMessage = MutableLiveData<ErrorModel>()
    val detailService: DetailApi = getRetrofit().create()


    fun getdetail(type: String, quantity: String) {

        val call = detailService.getActivityDetaill(type,quantity)

        call.enqueue(object : Callback<DetailModel>{

            override fun onResponse(call: Call<DetailModel>, response: Response<DetailModel>) {
                Log.i("Conection", "onResponse: ${response.body()} ")
                response.body().let {
                    detailActivity.postValue(it)
                }

            }

            override fun onFailure(call: Call<DetailModel>, t: Throwable) {
                Log.i("Conection", "onFailure: ${t.message}")

                Log.i("Conection", "onFailure: ${call.request().url()}")
                Log.i("Conection", "onFailure: ${call.request().body()}")
              //fallas del servidor
               call.cancel()
            }
        })

    }
    fun getdetailExample(quantity: String) {

        val call = detailService.getActivityDetaillEx()

        call.enqueue(object : Callback<DetailModel>{

            override fun onResponse(call: Call<DetailModel>, response: Response<DetailModel>) {
                Log.i("Conection", "onResponse: ${response.body()} ")
                response.body().let {
                    detailActivity.postValue(it)
                }

            }

            override fun onFailure(call: Call<DetailModel>, t: Throwable) {
                Log.i("Conection", "onFailure: ${t.message}")
                Log.i("Conection", "onFailure: ${call.request().url()}")

              //fallas del servidor
               call.cancel()
            }
        })

    }

}