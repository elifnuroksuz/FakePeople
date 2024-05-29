package com.elifnuroksuz.busonolsun.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.elifnuroksuz.busonolsun.database.ProductDao
import com.elifnuroksuz.busonolsun.database.ProductDatabase
import com.elifnuroksuz.busonolsun.model.Product
import com.elifnuroksuz.busonolsun.service.ProductAPIService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val productAPI = ProductAPIService()


    val countryData = MutableLiveData<List<Product>>()
    val countryLoad = MutableLiveData<Boolean>()
    val countryError = MutableLiveData<Boolean>()

    private var countryDatabase: ProductDatabase? = null
    private var countryDao: ProductDao? = null
    val country = MutableLiveData<Product>()


    init {
        countryDatabase = ProductDatabase.getInstance(application)
        countryDao = countryDatabase?.countryDao()
    }

    fun getDataFromAPI(){
        countryLoad.value = true

        productAPI.getData().enqueue(object: Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                countryData.value = response.body()
                countryLoad.value = false
                countryError.value = false
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                countryLoad.value = false
                countryError.value = true
                Log.e("RetrofitError",t.message.toString())
            }
        })

    }

    fun insertAll(list: List<Product>) = viewModelScope.launch {
        countryDao?.insertAll(list)
    }

    fun findByName (name:String) = viewModelScope.launch {
        country.value = countryDao?.findByName(name)
    }



}
