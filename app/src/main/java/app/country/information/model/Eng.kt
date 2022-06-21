package app.country.information.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Eng {
    @SerializedName("f")
    @Expose
    var f: String? = null

    @SerializedName("m")
    @Expose
    var m: String? = null
}