package app.country.information.interfaces

import app.country.information.model.Country

interface OnCountryClickListener {
    fun onCountryClicked(country: Country)
}