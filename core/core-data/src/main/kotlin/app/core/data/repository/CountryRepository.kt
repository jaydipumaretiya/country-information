package app.core.data.repository

import app.core.data.interfaces.CountryService
import app.core.exception.handleException
import app.core.model.Country
import app.core.network.Resource

class CountryRepository(private val countryService: CountryService) {
    suspend fun fetchAllCountries(): Resource<List<Country>> {
        return handleException { countryService.fetchAllCountries() }
    }
}