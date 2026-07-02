package com.techun.dev.tuskillgt.domain.usecase

import com.techun.dev.tuskillgt.domain.model.LoginResult
import com.techun.dev.tuskillgt.domain.repository.AuthRepository

class AuthUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(user: String, password: String): LoginResult {
        if (user.isBlank() || password.isBlank()) {
            return LoginResult.InvalidCredentials
        }
        val result = repository.doLogin(user.trim(), password)
        if (result is LoginResult.Success) {
            repository.setAuthenticated(true)
        }
        return result
    }
}