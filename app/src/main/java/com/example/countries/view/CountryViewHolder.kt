package com.example.countries.view


import androidx.recyclerview.widget.RecyclerView
import com.example.countries.databinding.ItemCountryBinding
import com.example.countries.model.Country

class CountryViewHolder(itemBinding: ItemCountryBinding): RecyclerView.ViewHolder(itemBinding.root) {

    private val countryName = itemBinding.name

    // this function is calling for each item of list
    fun bind(countryModel: Country) {
        countryName.text = countryModel.countryName
    }
}
