package com.bintangpoetra.moneybox.data.lib

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val errorMessage: String) : Result<Nothing>()
    object Loading : Result<Nothing>()
    object Empty : Result<Nothing>()
}