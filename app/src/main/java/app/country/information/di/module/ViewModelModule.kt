package app.country.information.di.module

import app.country.information.manager.CoroutinesManager
import app.country.information.ui.country.viewmodel.CountryViewModel
import app.country.information.util.NetworkHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CountryViewModel(get(), get(), get()) }
    single { NetworkHelper(androidApplication()) }
    single { CoroutinesManager() }
}