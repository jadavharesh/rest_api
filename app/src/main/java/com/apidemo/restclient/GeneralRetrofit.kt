package com.apidemo.restclient

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import android.util.Log
import retrofit2.Response
import com.google.gson.Gson

class GeneralRetrofit(call: Call<JsonElement>, params:Any?, dataresponseListener: DataresponseListener) {

    private val call: Call<JsonElement>? = call
    private val params: Any? = params
    private var dataResponseListener: DataresponseListener? = dataresponseListener

    fun call(): Call<JsonElement>? {
        Log.w("Inside Class", "--->   " + " API URL = " + call!!.request().url().toString())
        if (params != null && call.request().body() != null) {
            Log.w("Inside Class", "--->   " + " Passing Params = " + Gson().toJson(params))
        }
        call.enqueue(postCall)
        return call
    }

    private val postCall: Callback<JsonElement?> = object : Callback<JsonElement?> {
        override fun onResponse(call: Call<JsonElement?>, response: Response<JsonElement?>) {
            Log.w("Inside Class", "--->   " + " Status code : " + response.code())
            if (response.code() !== 200) {
                Log.w("Inside Class", "--->   " + " Response NOT OK : " + response.raw().message().toString())
            }

            var responseString: String? = null
            if (response.body() != null) {
                Log.w("Inside Class", "--->   " + " RESPONSE = " + java.lang.String.valueOf(response.body()))
                responseString = java.lang.String.valueOf(response.body())


                if (dataResponseListener != null) dataResponseListener!!.onSuccessresponse(responseString)
            } else {
                if (dataResponseListener != null) dataResponseListener!!.onFailure()
            }
        }

        override fun onFailure(call: Call<JsonElement?>, t: Throwable) {
            Log.w("Inside Class", "--->    ON_Failure = $t")
            if (!call.isCanceled) if (dataResponseListener != null) dataResponseListener!!.onFailure()
        }
    }
}