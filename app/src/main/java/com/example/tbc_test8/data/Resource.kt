package com.example.tbc_test8.data

sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(val error: String) : Resource<T>()
    data class Loading<T>(val loading: Boolean) : Resource<T>()
}