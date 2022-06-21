package app.country.information.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import app.country.information.network.Resource
import kotlinx.coroutines.Dispatchers
import java.io.IOException

class CountryViewModel(
    private val countryRepository: CountryRepository
) : ViewModel() {

    fun fetchAllCountries() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(
                Resource.success(
                    data = countryRepository.fetchAllCountries( )
                )
            )
        } catch (exception: Exception) {
            when (exception) {
                is IOException -> emit(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "IOException Error Occurred!"
                    )
                )
                else -> emit(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "Conversion Error Occurred!"
                    )
                )
            }
        }
    }
}