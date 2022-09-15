package app.core.database.di

import android.app.Application
import androidx.room.Room
import app.core.database.CountriesDatabase
import app.core.database.CountryDao
import org.koin.dsl.module

val databaseModule = module {

}

fun provideDatabase(
    application: Application
): CountriesDatabase {
    return Room
        .databaseBuilder(application, CountriesDatabase::class.java, "country.db")
        .fallbackToDestructiveMigration()
        .build()
}

fun provideCountriesDao(database: CountriesDatabase): CountryDao {
    return  database.countryDao()
}