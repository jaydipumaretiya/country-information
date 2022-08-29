package app.core.data.repository

import app.core.data.interfaces.CountryInterface
import app.core.exception.handleException
import app.core.model.Country
import app.core.network.Resource

class CountryRepository(private val countryInterface: CountryInterface) {
    suspend fun fetchAllCountries(): Resource<List<Country>> {
        return handleException { countryInterface.fetchAllCountries() }
    }
}