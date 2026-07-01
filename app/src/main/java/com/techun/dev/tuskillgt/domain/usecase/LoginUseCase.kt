package com.techun.dev.tuskillgt.domain.usecase

import com.techun.dev.tuskillgt.domain.model.LoginResult
import com.techun.dev.tuskillgt.domain.repository.RoomRepository

class LoginUseCase(private val repository: RoomRepository) {
    suspend operator fun invoke(user: String, password: String): LoginResult {
        if (user.isBlank() || password.isBlank()) {
            return LoginResult.InvalidCredentials
        }
        return repository.doLogin(user.trim(), password)
    }
}