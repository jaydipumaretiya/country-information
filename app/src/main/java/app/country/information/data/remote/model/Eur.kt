package app.country.information.data.remote.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Eur {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("symbol")
    @Expose
    var symbol: String? = null
}