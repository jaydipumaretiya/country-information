package app.country.information.network.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ApiInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val response = chain.proceed(request)
        if (response.code == 401) {
            refreshToken()
        }
        return response
    }

    private fun refreshToken() {
//        val sessionManager = SessionManager(PDApplication.application)
//        APIClient.client!!
//            .create(APIInterface::class.java)
//            .jwtTokens(
//                sessionManager.cookie!!
//            ).enqueue(object : Callback<JustResponse> {
//                override fun onResponse(
//                    call: Call<JustResponse>,
//                    response: retrofit2.Response<JustResponse>
//                ) {
//                    if (response.code() == 204) {
//                        sessionManager.accessToken = "Bearer ${response.headers()["Access-Token"]}"
//                        sessionManager.cookie = response.headers()["Set-Cookie"]
//                    }
//                }
//
//                override fun onFailure(call: Call<JustResponse>, t: Throwable) {
//                }
//            })
    }
}