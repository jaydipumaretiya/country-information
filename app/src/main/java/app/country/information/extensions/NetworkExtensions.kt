package app.country.information.extensions

import app.country.information.data.remote.exception.AppException
import app.country.information.data.remote.model.resource.Resource

suspend fun <T> handleException(apiCall: suspend () -> T): Resource<T> {
    return try {
        Resource.success(apiCall.invoke())
    } catch (throwable: Throwable) {
        Resource.error(AppException(throwable))
    }
}