package app.country.information.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Kor {
    @SerializedName("official")
    @Expose
    var official: String? = null

    @SerializedName("common")
    @Expose
    var common: String? = null
}