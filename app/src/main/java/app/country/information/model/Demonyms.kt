package app.country.information.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import app.country.information.model.Eng
import app.country.information.model.Fra__1

class Demonyms {
    @SerializedName("eng")
    @Expose
    var eng: Eng? = null

    @SerializedName("fra")
    @Expose
    var fra: Fra__1? = null
}