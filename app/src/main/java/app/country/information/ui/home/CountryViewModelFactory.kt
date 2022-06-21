package app.country.information.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.country.information.network.APIInterface

class CountryViewModelFactory(private val apiInterface: APIInterface) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
            return CountryViewModel(CountryRepository(apiInterface)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
