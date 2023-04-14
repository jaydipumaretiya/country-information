package app.country.information.di.module

import app.core.util.NetworkHelper
import app.base.manager.CoroutinesManager
import app.feature.country.viewmodel.CountryViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CountryViewModel(get(), get(), get()) }
    single { NetworkHelper(androidApplication()) }
    single { CoroutinesManager() }
}