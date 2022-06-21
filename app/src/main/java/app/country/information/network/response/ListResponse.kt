package app.country.information.network.response

import com.google.gson.annotations.SerializedName

class ListResponse<T> {
    var status: Boolean? = false
    var message: String? = null

    @SerializedName("interests")
    var interests: ArrayList<T>? = null

    @SerializedName("videos")
    var videos: ArrayList<T>? = null

    @SerializedName("property_type")
    var propertyTypes: ArrayList<T>? = null

    @SerializedName("amenity")
    var amenity: ArrayList<T>? = null

    @SerializedName("conversions")
    var conversions: ArrayList<T>? = null

    @SerializedName("messages")
    var messages: ArrayList<T>? = null

    @SerializedName("users")
    var users: ArrayList<T>? = null
}