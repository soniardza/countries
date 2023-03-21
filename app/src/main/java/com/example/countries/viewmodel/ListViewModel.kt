package com.example.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countries.model.Country

class ListViewModel: ViewModel() {

    // Anyone who subscribes to it will get notified whenever this variable is updated
    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<Boolean>() // get true/false
    // it will tell us whether it is the VM or the list of model is in  the process of loading the data from the backend
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    /**
     The actual functionality of the viewModel is in fetchCountries()
     It's private because we don't want to expose the functionality
     **/
    private fun fetchCountries() {
        val mockData = listOf(
            Country("CountryA"),
            Country("CountryB"),
            Country("CountryC"),
            Country("CountryD"),
            Country("CountryE"),
            Country("CountryF"),
            Country("CountryG"),
            Country("CountryH"),
            Country("CountryI"),
            Country("CountryJ")
        )

        // false = means that I have had no error in loading the data, so I need to notify all the subscribers
        countryLoadError.value = false
        loading.value = false
        // mockData = means that whoever is subscribed to my country's variable once I get the
        // information from the backend, I have a list of countries and I update my local variable
        countries.value = mockData
    }
}
