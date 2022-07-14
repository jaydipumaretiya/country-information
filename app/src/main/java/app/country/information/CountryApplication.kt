package app.country.information

import android.app.Application
import app.country.information.di.module.networkModule
import app.country.information.di.module.repoModule
import app.country.information.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Application class
 */
class CountryApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    viewModelModule,
                    repoModule,
                    networkModule
                )
            )
        }
    }
}