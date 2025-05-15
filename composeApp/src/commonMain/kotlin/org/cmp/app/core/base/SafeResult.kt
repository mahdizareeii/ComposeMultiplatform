package org.cmp.app.core.base

sealed class SafeResult<out Result> {
    data class Success<Result>(val data: Result) : SafeResult<Result>()
    data class Error(val error: Throwable) : SafeResult<Nothing>()
}

fun <T> Result<T>.safeResult(): SafeResult<T> {
    return if (isSuccess && getOrNull() != null) {
        SafeResult.Success<T>(getOrNull()!!)
    } else {
        SafeResult.Error(exceptionOrNull() ?: Throwable("Unknown"))
    }
}