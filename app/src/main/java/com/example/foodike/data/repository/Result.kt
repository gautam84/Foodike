package com.example.foodike.data.repository

sealed class Results<out R> {
    data class Success<out T>(val data: T) : Results<T>()
    data class Error(val exception: Exception) : Results<Nothing>()
}

fun <T> Results<T>.successOr(fallback: T): T {
    return (this as? Results.Success<T>)?.data ?: fallback
}
