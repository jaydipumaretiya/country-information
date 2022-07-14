package app.country.information.data.remote.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Demonyms {
    @SerializedName("eng")
    @Expose
    var eng: Eng? = null

    @SerializedName("fra")
    @Expose
    var fra: Fra__1? = null
}