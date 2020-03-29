package org.inghelram.plantjournal.data

sealed class Response<out T> {
    data class Success<T>(val data: T) : Response<T>()
    data class Error<T>(val throwable: Throwable) : Response<T>()
    data class Loading<T>(val data: T?) : Response<T>()
}