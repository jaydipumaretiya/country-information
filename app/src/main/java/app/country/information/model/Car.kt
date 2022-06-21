package app.country.information.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Car {
    @SerializedName("signs")
    @Expose
    var signs: List<String>? = null

    @SerializedName("side")
    @Expose
    var side: String? = null
}