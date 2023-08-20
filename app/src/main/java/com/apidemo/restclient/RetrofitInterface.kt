package com.apidemo.restclient

import com.apidemo.model.ModelDataItem
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("search?country=turkey")
    fun getUniversity(): Call<JsonElement>
}