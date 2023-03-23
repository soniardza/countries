package com.example.countries.di

import com.example.countries.model.CountriesService
import com.example.countries.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    /**
     * It will help Dagger inject the right components from API module into CountriesService
     */
    fun inject(service: CountriesService)

    fun inject(viewModel: ListViewModel)
}
