package app.country.information.data.remote.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class NativeName {
    @SerializedName("deu")
    @Expose
    var deu: Deu? = null
}