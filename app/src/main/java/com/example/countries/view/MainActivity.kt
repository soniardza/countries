package com.example.countries.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.databinding.ActivityMainBinding
import com.example.countries.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private lateinit var binding: ActivityMainBinding
    private val countriesAdapter = CountryListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        viewModel.refresh()

        initRecyclerView()

        observeViewModel()
    }

    private fun initRecyclerView() {
        binding.countryRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }
    }

    fun observeViewModel() {
        viewModel.countries.observe(
            this,
            Observer { countries ->
                countries?.let { countriesAdapter.updateCountries(it) }

            }
        )

        viewModel.countryLoadError.observe(
            this,
            Observer { isError ->
                isError?.let {
                    binding.listError.visibility = if (it) View.VISIBLE else View.GONE
                }
            }
        )

        viewModel.loading.observe(
            this,
            Observer { isLoading ->
                isLoading?.let {
                    binding.loadingView.visibility = if (it) View.VISIBLE else View.GONE
                    if (it) {
                        binding.listError.visibility = View.GONE
                        binding.countryRecyclerView.visibility = View.GONE
                    }
                }
            }
        )
    }
}
