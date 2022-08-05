package app.country.information.data.remote.country

import app.country.information.data.remote.model.Country
import retrofit2.http.GET

interface CountryInterface {

    @GET("all")
    suspend fun fetchAllCountries(): List<Country>
}