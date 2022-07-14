package app.country.information.data.remote.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class PostalCode {
    @SerializedName("format")
    @Expose
    var format: String? = null

    @SerializedName("regex")
    @Expose
    var regex: String? = null
}