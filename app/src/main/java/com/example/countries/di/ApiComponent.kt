package com.example.countries.di

import com.example.countries.model.CountriesService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    /**
     * It will help Dagger inject the right components from API module into CountriesService
     */
    fun inject(service: CountriesService)
}
