package app.country.information.data.remote.model.resource

import app.country.information.data.remote.exception.AppException


class Resource<out T> private constructor(
    val status: Status,
    val data: T?,
    private val exception: AppException?
) {

    enum class Status {
        SUCCESS, ERROR, LOADING, CANCEL
    }

    companion object {
        fun <T> success(data: T?): Resource<T> =
            Resource(status = Status.SUCCESS, data = data, exception = null)

        fun <T> error(exception: AppException? = null): Resource<T> =
            Resource(status = Status.ERROR, data = null, exception = exception)

        fun <T> loading(data: T? = null): Resource<T> =
            Resource(status = Status.LOADING, data = data, exception = null)

        fun <T> cancel(data: T? = null, exception: AppException? = null): Resource<T> =
            Resource(status = Status.CANCEL, data = data, exception = exception)
    }

    fun getErrorMessage() = exception?.getErrorMessage()
}