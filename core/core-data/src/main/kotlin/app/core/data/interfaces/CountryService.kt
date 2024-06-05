package app.core.data.interfaces

import app.core.model.Country
import retrofit2.http.GET

interface CountryService {

    @GET("all")
    suspend fun fetchAllCountries(): List<Country>
}