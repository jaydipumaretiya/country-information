package app.country.information.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import app.country.information.model.NativeName

class Name {
    @SerializedName("common")
    @Expose
    var common: String? = null

    @SerializedName("official")
    @Expose
    var official: String? = null

    @SerializedName("nativeName")
    @Expose
    var nativeName: NativeName? = null
}