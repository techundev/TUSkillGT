package com.techun.dev.tuskillgt.domain.usecase

import com.techun.dev.tuskillgt.domain.repository.AuthRepository

class LogoutUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke() = authRepository.doLogout()
}