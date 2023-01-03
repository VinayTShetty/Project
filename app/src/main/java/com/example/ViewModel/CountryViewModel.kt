package com.example.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.api.RetroInstance
import com.example.api.RetroServiceInterface
import com.example.data.Countries
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CountryViewModel : ViewModel() {
    var liveDataCountryList: MutableLiveData<List<Countries>?>

    init {
        liveDataCountryList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<Countries>?> {
        return liveDataCountryList
    }

    fun makeAPICall() {
        val retroInstance: Retrofit = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getListOfCountries()
        call.enqueue(object : Callback<List<Countries>?> {
            override fun onResponse(call: Call<List<Countries>?>, response: Response<List<Countries>?>) {
                    liveDataCountryList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Countries>?>, t: Throwable) {
                liveDataCountryList.postValue(null)
            }
        })
    }
}