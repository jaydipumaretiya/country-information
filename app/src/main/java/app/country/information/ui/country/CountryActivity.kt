package app.country.information.ui.country

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import app.country.information.R
import app.country.information.base.DataBindingActivity
import app.country.information.data.remote.model.Country
import app.country.information.data.remote.model.resource.Resource
import app.country.information.databinding.ActivityHomeBinding
import app.country.information.interfaces.OnCountryClickListener
import app.country.information.ui.country.viewmodel.CountryViewModel
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
        countryViewModel.makeNetworkCall()
    }

    private fun initUI() {
        setLinearRecyclerView(vb.rvCountries)
        vb.rvCountries.addItemDecoration(
            DividerItemDecoration(
                vb.rvCountries.context,
                (vb.rvCountries.layoutManager as LinearLayoutManager).orientation
            )
        )

        countriesAdapter = CountriesAdapter(this, arrayListOf(), this)
        vb.rvCountries.adapter = countriesAdapter
    }

    private fun initObservers() {
        countryViewModel.countries.observe(this) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { countries -> renderList(countries) }
                }
                Resource.Status.LOADING -> {

                }
                Resource.Status.ERROR -> {

                }
                Resource.Status.CANCEL -> {

                }
            }
        }
    }

    private fun renderList(users: List<Country>) {
        countriesAdapter.updateTemplates(users)
    }

    override fun onCountryClicked(country: Country) {
        val intent = Intent(this, CountryInformationActivity::class.java)
        intent.putExtra("country", country)
        startActivity(intent)
    }
}