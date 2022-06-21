package app.country.information.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Currencies {
    @SerializedName("EUR")
    @Expose
    var eur: Eur? = null
}