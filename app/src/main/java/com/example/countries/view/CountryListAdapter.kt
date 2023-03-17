package com.example.countries.view

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.countries.databinding.ItemCountryBinding
import com.example.countries.model.Country

class CountryListAdapter(var countries: ArrayList<Country>) :
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }
    /**
     * This method creates CountryViewHolder class
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemBinding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int = countries.size

    class CountryViewHolder(itemBinding: ItemCountryBinding): RecyclerView.ViewHolder(itemBinding.root) {

        private val countryName = itemBinding.name

        fun bind(country: Country) {
            countryName.text = country.countryName
        }
    }
}
