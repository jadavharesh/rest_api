package com.apidemo.restclient

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiClass {

    companion object{

        val apiInterface = RetrofitService.getApiInterface()

        fun getUniversity(dataresponseListener: DataresponseListener) {

           GeneralRetrofit(apiInterface!!.getUniversity(),"",dataresponseListener).call()
        }
    }
}