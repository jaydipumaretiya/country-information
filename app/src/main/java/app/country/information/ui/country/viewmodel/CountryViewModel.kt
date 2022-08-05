package app.country.information.ui.country.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.country.information.data.remote.example.CountryRepository
import app.country.information.data.remote.exception.AppException
import app.country.information.data.remote.model.Country
import app.country.information.data.remote.model.resource.Resource
import app.country.information.manager.CoroutinesManager
import app.country.information.util.NetworkHelper
import kotlinx.coroutines.*

class CountryViewModel(
    private val networkHelper: NetworkHelper,
    private val coroutinesManager: CoroutinesManager,
    private val countryRepository: CountryRepository
) : ViewModel() {

    private val _countries = MutableLiveData<Resource<List<Country>>>()
    val countries: LiveData<Resource<List<Country>>>
        get() = _countries

    fun makeNetworkCall() {
        coroutinesManager.ioScope.launch {
            if (networkHelper.isNetworkConnected()) {
                _countries.postValue(Resource.loading(null))
                countryRepository.fetchAllCountries().let {
                    _countries.postValue(Resource.success(it.data))
                }
            } else _countries.postValue(Resource.error(AppException("No internet connection")))
        }
    }
}
