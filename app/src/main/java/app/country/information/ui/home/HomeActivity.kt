package app.country.information.ui.home

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import app.country.information.R
import app.country.information.databinding.ActivityHomeBinding
import app.country.information.network.RetrofitBuilder
import app.country.information.network.Status
import app.country.information.ui.base.BaseActivity
import app.country.information.ui.base.delegate.viewBinding

class HomeActivity : BaseActivity(R.layout.activity_home) {

    private val binding by viewBinding(ActivityHomeBinding::inflate)

    override fun setContent() {
        setLinearRecyclerView(
            binding.rvCountries,
            RecyclerView.VERTICAL,
            reverseLayout = false,
            hasFixedSize = false,
            isNestedScrollingEnabled = true
        )

        val countriesAdapter = CountriesAdapter(
            this,
            ArrayList()
        )
        binding.rvCountries.adapter = countriesAdapter

        val templatesViewModel =
            ViewModelProvider(this, CountryViewModelFactory(RetrofitBuilder.apiInterface)).get(
                CountryViewModel::class.java
            )

        templatesViewModel.fetchAllCountries()
            .observe(this) {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            hideLoading()
                            resource.data?.let { countries ->
                                val newCountries =
                                    countries.sortedBy { country ->
                                        country.name!!.common
                                    }
                                countriesAdapter.updateTemplates(newCountries)
                            }
                        }
                        Status.ERROR -> {
//                            recyclerView.visibility = View.VISIBLE
//                            progressBar.visibility = View.GONE
                            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        }
                        Status.LOADING -> {
                            showLoading()
                        }
                    }
                }
            }
    }
}