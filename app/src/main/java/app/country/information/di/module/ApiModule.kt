package app.country.information.di.module

import app.country.information.BuildConfig
import app.country.information.data.remote.example.CountryRepository
import app.country.information.network.APIInterface
import org.koin.dsl.module

val repoModule = module {

    single { provideRetrofit(get(), BuildConfig.BASE_URL) }

    single { CountryRepository(get()) }

    factory { createWebService<APIInterface>(get()) }
}