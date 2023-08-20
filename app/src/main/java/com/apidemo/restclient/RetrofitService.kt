package com.apidemo.restclient

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    companion object {

        const val BASE_URL = "http://universities.hipolabs.com/"

        var httpClient: OkHttpClient = OkHttpClient().newBuilder().build()

        /*private var apiInterface: RetrofitInterface? = null
        private fun retrofit() {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            apiInterface=retrofit.create(RetrofitInterface::class.java)
        }*/

        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(httpClient)
            .build()

        fun getApiInterface():RetrofitInterface?{
            return retrofit.create(RetrofitInterface::class.java)
        }
    }
}