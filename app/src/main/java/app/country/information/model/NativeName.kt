package app.country.information.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import app.country.information.model.Deu

class NativeName {
    @SerializedName("deu")
    @Expose
    var deu: Deu? = null
}