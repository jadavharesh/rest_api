package com.apidemo.restclient

interface DataresponseListener {
    fun onSuccessresponse(response:String)
    fun onFailure()
}