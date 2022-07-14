package app.country.information.data.remote.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Nld {
    @SerializedName("official")
    @Expose
    var official: String? = null

    @SerializedName("common")
    @Expose
    var common: String? = null
}