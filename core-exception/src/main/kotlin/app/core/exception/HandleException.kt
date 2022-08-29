package app.core.exception

import app.core.network.Resource
import app.core.network.exception.AppException

suspend fun <T> handleException(apiCall: suspend () -> T): Resource<T> {
    return try {
        Resource.success(apiCall.invoke())
    } catch (throwable: Throwable) {
        Resource.error(AppException(throwable))
    }
}