package app.country.information.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Idd {
    @SerializedName("root")
    @Expose
    var root: String? = null

    @SerializedName("suffixes")
    @Expose
    var suffixes: List<String>? = null
}