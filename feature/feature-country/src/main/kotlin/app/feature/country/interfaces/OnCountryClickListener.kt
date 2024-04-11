package app.feature.country.interfaces

import app.core.model.Country

interface OnCountryClickListener {
    fun onCountryClicked(country: Country)
}