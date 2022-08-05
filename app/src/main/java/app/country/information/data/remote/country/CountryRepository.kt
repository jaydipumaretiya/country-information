package app.country.information.data.remote.country

import app.country.information.data.remote.model.Country
import app.country.information.data.remote.model.resource.Resource
import app.country.information.extensions.handleException

class CountryRepository(private val countryInterface: CountryInterface) {
    suspend fun fetchAllCountries(): Resource<List<Country>> {
        return handleException { countryInterface.fetchAllCountries() }
    }
}