package app.country.information.ui.country.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.country.information.data.remote.example.CountryRepository
import app.country.information.data.remote.exception.AppException
import app.country.information.data.remote.model.Country
import app.country.information.data.remote.model.resource.Resource
import app.country.information.manager.CoroutinesManager
import app.country.information.ui.utils.ResourceProvider
import kotlinx.coroutines.*

class CountryViewModel(
    private val resourceProvider: ResourceProvider,
    private val coroutinesManager: CoroutinesManager,
    private val countryRepository: CountryRepository
) : ViewModel() {

    companion object {
        private const val logTag = "CountryRepository"
    }

    private val _countries = MutableLiveData<Resource<List<Country>>>()
    val countries: LiveData<Resource<List<Country>>>
        get() = _countries

    fun makeNetworkCall() {
        coroutinesManager.ioScope.launch {
            _countries.postValue(Resource.loading(null))
//            if (networkHelper.isNetworkConnected()) {
                countryRepository.fetchAllCountries().let {
//                    if (it.isSuccessful) {
                        _countries.postValue(Resource.success(it.data))
//                    } else _countries.postValue(Resource.error(AppException(it.getErrorMessage()!!)))
                }
//            } else _countries.postValue(Resource.error(AppException("No internet connection")))
//        Log.i(logTag, "Set TextView using DataBinding")
//        textObservable.set(resourceProvider.getString(R.string.info_txt))
//
//        coroutinesManager.ioScope.launch {
//            val deferredList = ArrayList<Deferred<*>>()
//
//            Log.i(logTag, "Make 10 concurrent network calls")
//            for (i in 0..10) {
//
//                deferredList.add(async {
//                    Log.i(logTag, "Network Call ID: $i")
//                    countryRepository.fetchAllCountries()
//                })
//            }
//
//            deferredList.joinAll()
//            Log.i(logTag, "All Networks calls complete")
//
//            updateEvent.postValue(true)
//            Log.i(logTag, "Update UI")
        }
    }
}
