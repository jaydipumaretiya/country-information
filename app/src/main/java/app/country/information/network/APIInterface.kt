package app.country.information.network

import app.country.information.data.remote.model.Country
import retrofit2.http.GET

interface APIInterface {

    @GET("all")
    suspend fun fetchAllCountries(): List<Country>

//    @FormUrlEncoded
//    @POST("poster")
//    suspend fun fetchPosterById(
//        @Field("key") key: String?,
//        @Field("device") device: Int?,
//        @Field("cat_id") cat_id: Int?,
//        @Field("post_id") post_id: String?
//    ): RestResponse<PosterResponse>
}