package app.country.information.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class CapitalInfo {
    @SerializedName("latlng")
    @Expose
    var latlng: List<Double>? = null
}