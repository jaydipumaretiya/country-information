package app.country.information.network.response

import com.google.gson.annotations.SerializedName

class RestResponse<T> {
    var status: Boolean? = false
    var message: String? = null

    var user: T? = null

    var video: T? = null

    @SerializedName("verified_OTP")
    var isVerified: Boolean? = false

    @SerializedName("role_name")
    var roleName: String? = null
}