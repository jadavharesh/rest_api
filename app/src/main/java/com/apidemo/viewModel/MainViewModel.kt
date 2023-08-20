package com.apidemo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apidemo.model.ModelDataItem
import com.apidemo.restclient.ApiClass
import com.apidemo.restclient.DataresponseListener
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class MainViewModel : ViewModel() {

    val universityList = MutableLiveData<List<ModelDataItem>>()
    val errorMessage = MutableLiveData<String>()

    init {
        getUniversity()
    }

    fun getUniversity()
    {
        ApiClass.getUniversity(object : DataresponseListener {
            override fun onSuccessresponse(response: String) {
                try {
                    val gson = GsonBuilder().create()
                    val groupListType: Type = object : TypeToken<ArrayList<ModelDataItem?>?>() {}.type
                    val model: List<ModelDataItem> = gson.fromJson(response, groupListType)
                    universityList.postValue(model)
                }catch (e:Exception)
                {
                }
            }

            override fun onFailure() {
                errorMessage.postValue("Error")
            }
        })
    }
}