package com.example.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countries.di.DaggerApiComponent
import com.example.countries.model.CountriesService
import com.example.countries.model.Country
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListViewModel : ViewModel() {

    @Inject
    lateinit var countriesService: CountriesService

    init {
        DaggerApiComponent.create().inject(this)
    }

    private val disposable = CompositeDisposable() //

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
        loading.value = true
        disposable.add(
            countriesService.getCountries() // get a single list countries
                .subscribeOn(Schedulers.newThread()) // we relegate all the process on the background thread (new thread) // subscribe to this observable on this thread
                .observeOn(AndroidSchedulers.mainThread()) // we get all the information on main thread
                .subscribeWith(object : DisposableSingleObserver<List<Country>>() {
                    override fun onSuccess(value: List<Country>?) {
                        countries.value = value
                        countryLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable?) {
                        countryLoadError.value = true
                        loading.value = false
                    }
                }),
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
