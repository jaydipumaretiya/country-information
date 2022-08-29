package app.country.information.interfaces

import app.core.model.Country

interface OnCountryClickListener {
    fun onCountryClicked(country: Country)
}