package com.ec3.jurado.data.response

import java.lang.Exception

sealed class TeamResponse<out T> {
    data class Success<out T>(val data: T) : TeamResponse<T>()
    data class Error(val exception: Exception) : TeamResponse<Nothing>()
}