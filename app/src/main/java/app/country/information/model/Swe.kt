package app.country.information.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Swe {
    @SerializedName("official")
    @Expose
    var official: String? = null

    @SerializedName("common")
    @Expose
    var common: String? = null
}