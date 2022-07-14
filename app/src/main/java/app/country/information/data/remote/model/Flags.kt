package app.country.information.data.remote.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Flags {
    @SerializedName("png")
    @Expose
    var png: String? = null

    @SerializedName("svg")
    @Expose
    var svg: String? = null
}