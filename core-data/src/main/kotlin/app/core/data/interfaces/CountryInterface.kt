package app.core.data.interfaces

import app.core.model.Country
import retrofit2.http.GET

interface CountryInterface {

    @GET("all")
    suspend fun fetchAllCountries(): List<Country>
}