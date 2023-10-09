/*
In NetworkResult Class we have derived when we raise API request we will use NetworkResult class
to maintain Loading State and if NetworkResult is Success data will occur
if Error, Error Message will show on screen.
 */
package com.example.notesappapi.utils

sealed class NetworkResult<T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T) : NetworkResult<T>(data)
    class Error<T>(message: String?, data: T? = null) : NetworkResult<T>(data, message)
    class Loading<T> : NetworkResult<T>()
}