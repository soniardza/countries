package com.example.countries.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountriesService {

    private val BASE_URL = "https://raw.githubusercontent.com"
    private val api: CountriesApi

    init {
        api = Retrofit.Builder()// creates the the framework for retrofit which help us to get the information from the backend
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // transform the Json into data class country
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // transform our data into an observable variable
            .build()
            .create(CountriesApi::class.java) // be able to return a list of country, single = an observable that emits one variable and then closes
    }

    fun getCountries(): Single<List<Country>> {
        return api.getCountries()
    }
}
