package app.country.information.interfaces

import app.country.information.data.remote.model.Country

interface OnCountryClickListener {
    fun onCountryClicked(country: Country)
}