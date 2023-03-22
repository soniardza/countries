package com.example.countries.view


import androidx.recyclerview.widget.RecyclerView
import com.example.countries.databinding.ItemCountryBinding
import com.example.countries.model.Country
import com.example.countries.util.getProgressDrawable
import com.example.countries.util.loadImage

class CountryViewHolder(itemBinding: ItemCountryBinding): RecyclerView.ViewHolder(itemBinding.root) {

    private val imageView = itemBinding.imageVIew
    private val countryName = itemBinding.name
    private val countryCapital = itemBinding.capital
    private val progressDrawable = getProgressDrawable(itemBinding.root.context) // a Spiner than will show up the image
    // this function is calling for each item of list
    fun bind(countryModel: Country) {
        countryName.text = countryModel.countryName
        countryCapital.text = countryModel.capital
        imageView.loadImage(countryModel.flag, progressDrawable)
    }
}
