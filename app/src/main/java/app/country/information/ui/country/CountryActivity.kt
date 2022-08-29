package app.country.information.ui.country

import android.content.Intent
import android.os.Bundle
import android.util.Log
import app.base.DataBindingActivity
import app.core.extensions.afterTextChanged
import app.core.model.Country
import app.core.network.Resource
import app.country.information.R
import app.country.information.databinding.ActivityHomeBinding
import app.country.information.interfaces.OnCountryClickListener
import app.country.information.ui.country.viewmodel.CountryViewModel
import app.country.information.ui.utils.Constants
import org.koin.android.ext.android.inject

class CountryActivity : DataBindingActivity<ActivityHomeBinding>(), OnCountryClickListener {

    private val countryViewModel by inject<CountryViewModel>()
    private lateinit var countriesAdapter: CountriesAdapter

    override fun layoutId(): Int = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb.countryViewModel = countryViewModel

        initUI()
        initObservers()
        countryViewModel.fetchAllCountries()

        vb.edtSearch.afterTextChanged {
            countriesAdapter.filter.filter(it)
        }
    }

    private fun initUI() {
        setLinearRecyclerView(vb.rvCountries)
        countriesAdapter = CountriesAdapter(this, arrayListOf(), this)
        vb.rvCountries.adapter = countriesAdapter
    }

    private fun initObservers() {
        countryViewModel.countries.observe(this) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    hideLoading()
                    it.data?.let { countries -> renderCountries(countries) }
                }
                Resource.Status.LOADING -> {
                    showLoading()
                }
                Resource.Status.ERROR -> {
                    hideLoading()
                    Log.e("ERROR", " ---- " + it.getErrorMessage())
                }
                Resource.Status.CANCEL -> {
                    hideLoading()
                    Log.e("CANCEL", " ---- ")
                }
            }
        }
    }

    private fun renderCountries(countries: List<Country>) {
        countriesAdapter.updateTemplates(countries)
    }

    override fun onCountryClicked(country: Country) {
        val intent = Intent(this, CountryInformationActivity::class.java)
        intent.putExtra(Constants.EXTRA_COUNTRY, country)
        startActivity(intent)
    }
}