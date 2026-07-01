package com.techun.dev.tuskillgt.domain.model

sealed class LoginResult {
    data object Success : LoginResult()
    data object InvalidCredentials : LoginResult()
    data class Error(val message: String) : LoginResult()
}