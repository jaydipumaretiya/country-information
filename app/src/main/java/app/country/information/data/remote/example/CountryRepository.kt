package app.country.information.data.remote.example

import app.country.information.data.remote.model.Country
import app.country.information.data.remote.model.resource.Resource
import app.country.information.extensions.handleException
import app.country.information.network.APIInterface

class CountryRepository(private val apiInterface: APIInterface) {
    suspend fun fetchAllCountries(): Resource<List<Country>> {
        return handleException { apiInterface.fetchAllCountries() }
    }
}