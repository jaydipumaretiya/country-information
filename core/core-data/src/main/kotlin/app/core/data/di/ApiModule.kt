package app.core.data.di

import app.core.data.interfaces.CountryService
import app.core.data.repository.CountryRepository
import app.core.network.di.createWebService
import app.core.network.di.provideRetrofit
import org.koin.dsl.module

val repoModule = module {

    single { provideRetrofit(get(), "https://restcountries.com/v3.1/") }

    single { CountryRepository(get()) }

    factory { createWebService<CountryService>(get()) }
}