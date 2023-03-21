package com.example.countries.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.databinding.ItemCountryBinding
import com.example.countries.model.Country

class CountryListAdapter(var countriesList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateCountries(newCountries: List<Country>) {
        countriesList.clear()
        countriesList.addAll(newCountries)
        notifyDataSetChanged()
    }
    /**
     * This method creates CountryViewHolder class
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemBinding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(itemBinding)
    }

    // This method goes for each item of list and calls Bind()
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val item = countriesList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = countriesList.size

}
