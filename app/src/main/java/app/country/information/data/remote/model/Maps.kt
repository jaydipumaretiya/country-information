package app.country.information.data.remote.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Maps {
    @SerializedName("googleMaps")
    @Expose
    var googleMaps: String? = null

    @SerializedName("openStreetMaps")
    @Expose
    var openStreetMaps: String? = null
}