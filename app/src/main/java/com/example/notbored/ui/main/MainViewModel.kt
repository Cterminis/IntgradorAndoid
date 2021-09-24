package com.example.notbored.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notbored.core.RetrofitHelper.getRetrofit
import com.example.notbored.data.model.DetailModel
import com.example.notbored.data.model.ErrorModel
import com.example.notbored.data.network.service.DetailApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainViewModel : ViewModel() {

    val isLoadingProgressBar = MutableLiveData<Boolean>()
    val detailActivity = MutableLiveData<DetailModel>()
    val errMessage = MutableLiveData<Boolean>()
    val errShowMessage = MutableLiveData<ErrorModel>()
    val detailService: DetailApi = getRetrofit().create()


    fun getdetail(type: String, quantity: String) {
        isLoadingProgressBar.postValue(true)
        errMessage.postValue(false)
        val call = detailService.getActivityDetaill(type, quantity)

        call.enqueue(object : Callback<DetailModel> {

            override fun onResponse(call: Call<DetailModel>, response: Response<DetailModel>) {
                Log.i("Conection", "onResponse: ${response.body()} ")

                response.body().let { detail ->

                    detail?.price?.let {
                        isLoadingProgressBar.postValue(false)
                        detailActivity.postValue(detail)

                    } ?: errShowMessage.let {

                        isLoadingProgressBar.postValue(false)
                        errMessage.postValue(true)
                        it.postValue(ErrorModel(detail!!.error))
                    }

                }
            }


            override fun onFailure(call: Call<DetailModel>, t: Throwable) {
                Log.i("Conection", "onFailure: ${t.message}, URL:  ${call.request().url()}" )
                isLoadingProgressBar.postValue(false)
                errMessage.postValue(true)
                //fallas del servidor
                call.cancel()
            }
        })
    }


    fun getDetailRandom() {

        val call = detailService.getActivityDetaillRandom()

        call.enqueue(object : Callback<DetailModel> {

            override fun onResponse(call: Call<DetailModel>, response: Response<DetailModel>) {

                Log.i("Conection", "onResponse: ${response.body()} ")
                response.body().let {
                    detailActivity.postValue(it)
                }

            }

            override fun onFailure(call: Call<DetailModel>, t: Throwable) {
                Log.i("Conection", "onFailure: ${t.message}, URl:${call.request().url()}")

                call.cancel()
            }
        })

    }

}