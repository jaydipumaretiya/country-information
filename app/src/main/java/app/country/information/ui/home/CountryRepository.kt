package app.country.information.ui.home

import app.country.information.network.APIInterface

class CountryRepository(private val apiInterface: APIInterface) {
    suspend fun fetchAllCountries() = apiInterface.fetchAllCountries()
}